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
    Services service ;
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


        binding.book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(service.getWith_extra_data()==1){
                    Navigation.findNavController(v).navigate(R.id.action_detailsFragment_to_featureFragment);
                }
                else{
                    Navigation.findNavController(v).navigate(R.id.action_detailsFragment_to_pickDateTimeFragment);
                }
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        servicesViewModel.getAllServices().observe(requireActivity(), new Observer<List<Services>>() {
            @Override
            public void onChanged(List<Services> services) {

            }
        });
        servicesViewModel.get_ser_by_id(args.getSerID(), new ServicesOneValueListener() {
            @Override
            public void onValueSubmit(Services servicesu) {
                service=servicesu;

                binding.title.setText(servicesu.getSertitle());
                binding.categoty.setText(servicesu.getSerCat());
                binding.details.setText(servicesu.getSerDiscribtion());
                binding.price.setText(servicesu.getSerPrice());
                Oders oders = new Oders(servicesu.getId(),servicesu.getSer_Price(),servicesu.getSertitle(),servicesu.getSerCat());
                servicesViewModel.insert(oders);

            }
        });


    }
}