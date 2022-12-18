package com.example.homeservise;

import android.content.Context;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.homeservise.Domain.Oders;
import com.example.homeservise.Domain.OrderOneValueListener;
import com.example.homeservise.Home.Backpressedlistener;
import com.example.homeservise.Home.ServicesViewModel;
import com.example.homeservise.adapters.OrderAdapterAll;
import com.example.homeservise.databinding.FragmentOffersBinding;
import com.example.homeservise.databinding.FragmentOrdersBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;


public class OrdersFragment extends Fragment   {
FragmentOrdersBinding binding;
//public static Backpressedlistener backpressedlistener;

RecyclerView recyclerView_order;
OrderAdapterAll orderAdapterAll;
ServicesViewModel servicesViewModel;
NavController navController;
BottomNavigationView bottomNavigationView;

    public OrdersFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentOrdersBinding.inflate(inflater,container,false);

        servicesViewModel=new ViewModelProvider(requireActivity()).get(ServicesViewModel.class);
        orderAdapterAll =new OrderAdapterAll(new OrderOneValueListener() {
            @Override
            public void onValueSubmit(Oders order, View itemView) {
                servicesViewModel.delete(order);
                OrdersFragmentDirections.ActionOrdersFragmentToFinalOrderDetailsFragment action=OrdersFragmentDirections.actionOrdersFragmentToFinalOrderDetailsFragment(order);
                Navigation.findNavController(itemView).navigate(action);



            }
        });
        recyclerView_order=binding.recyclerViewOrders;
        recyclerView_order.setLayoutManager(new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView_order.setHasFixedSize(true);
        recyclerView_order.setAdapter(orderAdapterAll);


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        servicesViewModel.getAllOders().observe(requireActivity(), new Observer<List<Oders>>() {
            @Override
            public void onChanged(List<Oders> oders) {
                orderAdapterAll.setData(oders);
            }
        });



    }






}