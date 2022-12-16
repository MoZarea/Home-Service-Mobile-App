package com.example.homeservise;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homeservise.Domain.Oders;
import com.example.homeservise.Home.ServicesViewModel;
import com.example.homeservise.databinding.FragmentFeatureBinding;
import com.google.android.material.chip.ChipGroup;


public class FeatureFragment extends Fragment {
    FragmentFeatureBinding binding;
    ServicesViewModel servicesViewModel;
    ChipGroup num_of_pieces_CG,extra_CG;
//    FeatureFragmentArgs args;

    public FeatureFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding=FragmentFeatureBinding.inflate(inflater,container,false);
       servicesViewModel=new ViewModelProvider(requireActivity()).get(ServicesViewModel.class);
//       args=FeatureFragmentArgs.fromBundle(getArguments());
       num_of_pieces_CG =binding.room;
       extra_CG=binding.extras;










       return binding.getRoot();
    }
}