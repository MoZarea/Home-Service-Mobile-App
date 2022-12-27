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

import com.example.homeservise.Listener.Service.FavorListener;
import com.example.homeservise.Data.Service.Services;
import com.example.homeservise.Listener.Service.ServicesValueListener;
import com.example.homeservise.adapters.ServicesAdapterAll;
import com.example.homeservise.databinding.FragmentAllServicesBinding;

import java.util.List;


public class AllServicesFragment extends Fragment {
    RecyclerView recyclerViewAllSer;
    ServicesViewModel servicesViewModel;
    ServicesAdapterAll servicesAdapterAll;
    AllServicesFragmentArgs args;
    FragmentAllServicesBinding binding;

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
        servicesViewModel = new ViewModelProvider(requireActivity()).get(ServicesViewModel.class);


        /*--------------->getting arguments<---------------*/
        args = AllServicesFragmentArgs.fromBundle(getArguments());

        /*--------------->adapter binding<---------------*/
        recyclerViewAllSer = binding.recyclerViewAllServices;
        servicesAdapterAll = new ServicesAdapterAll(new OnServiceSelectedFromAll() {
            @Override
            public void onServiceSelected(Services services, View view) {

                /*
                 * Navigation to Details Fragment and show data
                 * based on service selected and pass data required to destination
                 */
                AllServicesFragmentDirections.ActionAllServicesFragmentToDetailsFragment action = AllServicesFragmentDirections.actionAllServicesFragmentToDetailsFragment(services);
                Navigation.findNavController(view).navigate(action);
            }
        }, new FavorListener() {
            @Override
            public void onbuttonSubmit(Services current_service) {

                servicesViewModel.update(current_service);
            }
        });
        recyclerViewAllSer.setLayoutManager(new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerViewAllSer.setHasFixedSize(true);
        recyclerViewAllSer.setAdapter(servicesAdapterAll);

        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String cat = args.getCAT();
        /*--------------->set adapter with values<---------------*/
        /*--------------->99 is value refer to (show all data)  <---------------*/
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