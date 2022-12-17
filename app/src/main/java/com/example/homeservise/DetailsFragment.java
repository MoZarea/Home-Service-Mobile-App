package com.example.homeservise;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homeservise.Domain.Oders;
import com.example.homeservise.Domain.Services;
import com.example.homeservise.Domain.ServicesOneValueListener;
import com.example.homeservise.Home.ServicesViewModel;
import com.example.homeservise.databinding.FragmentDetailsBinding;

import java.util.List;

public class DetailsFragment extends Fragment {
    FragmentDetailsBinding binding;
    DetailsFragmentArgs args;
    ServicesViewModel servicesViewModel;
    Oders new_oders ;
    public DetailsFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentDetailsBinding.inflate(inflater,container,false);
        servicesViewModel=new ViewModelProvider(requireActivity()).get(ServicesViewModel.class);
        //recieve Argument
        args=DetailsFragmentArgs.fromBundle(getArguments());
        //bind data recieved to layout

        binding.title.setText(args.getService().getSertitle());
        binding.categoty.setText(args.getService().getSerCat());
        binding.details.setText(args.getService().getSerDiscribtion());
        binding.price.setText(args.getService().getSerPrice());
        new_oders=new Oders();

        binding.book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(args.getService().getWith_extra_data()==1){

                    DetailsFragmentDirections.ActionDetailsFragmentToFeatureFragment action=DetailsFragmentDirections.actionDetailsFragmentToFeatureFragment(args.getService(),new_oders);
                    Navigation.findNavController(v).navigate(action);
                }
                else{
                    new_oders.setNotes("لطلب خدمات اضافيه يرجي التحديد مع خدمة العملاء");
                    new_oders.setTotalCost(args.getService().getSer_Price());
                    new_oders.setServiceID(args.getService().getId());
                    new_oders.setSer_title(args.getService().getSertitle());
                    new_oders.setCat_title(args.getService().getSerCat());
                    DetailsFragmentDirections.ActionDetailsFragmentToPickDateTimeFragment action=DetailsFragmentDirections.actionDetailsFragmentToPickDateTimeFragment(args.getService(),new_oders);

                    Navigation.findNavController(v).navigate(action);
                }
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}