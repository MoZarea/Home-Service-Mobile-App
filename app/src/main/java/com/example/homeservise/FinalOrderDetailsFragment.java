package com.example.homeservise;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.homeservise.Domain.Oders;
import com.example.homeservise.Domain.OrderValueListener;
import com.example.homeservise.Home.ServicesViewModel;
import com.example.homeservise.databinding.FragmentFinalOrderDetailsBinding;
import com.example.homeservise.databinding.FragmentPreferedBinding;

import java.util.List;


public class FinalOrderDetailsFragment extends Fragment {
    FragmentFinalOrderDetailsBinding binding;
    FinalOrderDetailsFragmentArgs args;
    ServicesViewModel servicesViewModel;
    Oders ordersss;




    public FinalOrderDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        args=FinalOrderDetailsFragmentArgs.fromBundle(getArguments());
        servicesViewModel=new ViewModelProvider(requireActivity()).get(ServicesViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFinalOrderDetailsBinding.inflate(inflater, container, false);
        servicesViewModel=new ViewModelProvider(requireActivity()).get(ServicesViewModel.class);
        String txt =args.getOrder().getSer_title().toString();
        binding.orderServiceTitle.setText(txt);
        binding.oderNumDetails.setText("اوردر رقم : "+args.getOrder().getOrderID());
        binding.orderFinalCost.setText("السعر : "+args.getOrder().getTotalCost());
        binding.orderCatFinal.setText(args.getOrder().getCat_title());
        binding.textView19.setText(args.getOrder().getParticular_address());
        binding.orderDate.setText(args.getOrder().getDate());
        binding.orderTime.setText(args.getOrder().getTime());
        binding.notes.setText(args.getOrder().getNotes());
        binding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                servicesViewModel.delete(args.getOrder());
                Navigation.findNavController(v).navigate(R.id.homeFragment2);
            }
        });

        return binding.getRoot();
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);





    }
}