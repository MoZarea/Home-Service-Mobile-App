package com.example.homeservise.Home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homeservise.Domain.FavorListener;
import com.example.homeservise.Domain.Services;
import com.example.homeservise.Domain.ServicesValueListener;
import com.example.homeservise.adapters.ServicesAdapterAll;
import com.example.homeservise.databinding.FragmentAllServicesBinding;

import java.util.List;


public class AllServicesFragment extends Fragment {
    RecyclerView recyclerViewAllSer;
    CategoryViewModel categoryViewModel;
    ServicesViewModel servicesViewModel;
    ServicesAdapterAll servicesAdapterAll;
    AllServicesFragmentArgs args;
    FragmentAllServicesBinding binding;
    private String mParam2;
//    Services services;

    public AllServicesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAllServicesBinding.inflate(inflater, container, false);

        //Recieve argument
        args = AllServicesFragmentArgs.fromBundle(getArguments());

        //////////////////////////////////////////////////////////
        /////// All Services Adapter with Recycler View /////////
        ////////////////////////////////////////////////////////
        recyclerViewAllSer = binding.recyclerViewAllServices;
        servicesAdapterAll = new ServicesAdapterAll(new OnServiceSelectedFromAll() {
            @Override
            public void onServiceSelected(Services services, View view) {


                /*
                 * Navigation to Details Fragment and show data
                 * based on service selected and pass data required to destination
                 */
                //TODO with feature is disable ... you should implement function for that
                AllServicesFragmentDirections.ActionAllServicesFragmentToDetailsFragment action = AllServicesFragmentDirections.actionAllServicesFragmentToDetailsFragment(services.getSertitle(), services.getSerCat(), services.getSerDiscribtion(), services.getSerPrice(), false);
                Navigation.findNavController(view).navigate(action);
            }
        }, new FavorListener() {
            @Override
            public void onbuttonSubmit(Services current_service, boolean is_checked) {
                if (is_checked) {
                    current_service.setIs_favorite(1);
                } else {
                    current_service.setIs_favorite(0);
                }
                servicesViewModel.update(current_service);
            }
        });
        recyclerViewAllSer.setLayoutManager(new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerViewAllSer.setHasFixedSize(true);
        recyclerViewAllSer.setAdapter(servicesAdapterAll);
        servicesViewModel = new ViewModelProvider(requireActivity()).get(ServicesViewModel.class);

        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String cat = args.getCAT();
        //set adapter with values
        if(cat=="99"){
            servicesViewModel.getAllServices().observe(requireActivity(), new Observer<List<Services>>() {
                @Override
                public void onChanged(List<Services> services) {
                    servicesAdapterAll.setData(services);
                }
            });
        }
        else{
        servicesViewModel.getAllServicesByCat(cat, new ServicesValueListener() {
            @Override
            public void onValueSubmit(List<Services> services) {
                servicesAdapterAll.setData(services);
            }
        });}



    }
}