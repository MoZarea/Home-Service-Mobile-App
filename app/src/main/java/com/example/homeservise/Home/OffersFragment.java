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
import com.example.homeservise.adapters.ServicesAdapterAll;
import com.example.homeservise.databinding.FragmentOffersBinding;

import java.util.List;


public class OffersFragment extends Fragment {
    FragmentOffersBinding binding;
    RecyclerView recyclerViewOffers;
    ServicesAdapterAll servicesAdapterAll;
    ServicesViewModel servicesViewModel;


    public OffersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentOffersBinding.inflate(inflater,container,false);
        servicesViewModel=new ViewModelProvider(requireActivity()).get(ServicesViewModel.class);

        /*--------------->adapter binding<---------------*/
        recyclerViewOffers=binding.OfferRV;
        servicesAdapterAll=new ServicesAdapterAll(new OnServiceSelectedFromAll() {
            @Override
            public void onServiceSelected(Services services, View view) {
                OffersFragmentDirections.ActionOffersFragment2ToDetailsFragment action = OffersFragmentDirections.actionOffersFragment2ToDetailsFragment(services);
                Navigation.findNavController(view).navigate(action);

            }
        }, new FavorListener() {
            @Override
            public void onbuttonSubmit(Services current_service) {

                servicesViewModel.update(current_service);

            }
        });
        recyclerViewOffers.setLayoutManager(new LinearLayoutManager(requireActivity()));
        recyclerViewOffers.setHasFixedSize(true);
        recyclerViewOffers.setAdapter(servicesAdapterAll);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*--------------->update adapter with data<---------------*/
        servicesViewModel.getAllOffers().observe(requireActivity(), new Observer<List<Services>>() {
            @Override
            public void onChanged(List<Services> services) {
                servicesAdapterAll.setData(services);
            }
        });

    }
}