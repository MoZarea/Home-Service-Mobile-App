package com.example.homeservise.Home;

import android.os.Bundle;

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

import com.example.homeservise.Data.Order.Orders;
import com.example.homeservise.Listener.Order.OrderOneValueListener;
import com.example.homeservise.adapters.OrderAdapterAll;
import com.example.homeservise.databinding.FragmentOrdersBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;


public class OrdersFragment extends Fragment   {
FragmentOrdersBinding binding;

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
        /*--------------->adapter binding<---------------*/
        orderAdapterAll =new OrderAdapterAll(new OrderOneValueListener() {
            @Override
            public void onValueSubmit(Orders orderss, View itemView) {
                OrdersFragmentDirections.ActionOrdersFragmentToFinalOrderDetailsFragment action=OrdersFragmentDirections.actionOrdersFragmentToFinalOrderDetailsFragment(orderss);
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
        /*--------------->update adapter with data<---------------*/
        servicesViewModel.getAllOders().observe(requireActivity(), new Observer<List<Orders>>() {
            @Override
            public void onChanged(List<Orders> oders) {
                orderAdapterAll.setData(oders);
            }
        });
    }






}