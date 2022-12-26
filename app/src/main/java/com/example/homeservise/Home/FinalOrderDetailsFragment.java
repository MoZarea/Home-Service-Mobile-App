package com.example.homeservise.Home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.homeservise.Data.Order.Orders;
import com.example.homeservise.R;
import com.example.homeservise.databinding.FragmentFinalOrderDetailsBinding;


public class FinalOrderDetailsFragment extends Fragment {
    FragmentFinalOrderDetailsBinding binding;
    FinalOrderDetailsFragmentArgs args;
    ServicesViewModel servicesViewModel;
    Orders ordersss;

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