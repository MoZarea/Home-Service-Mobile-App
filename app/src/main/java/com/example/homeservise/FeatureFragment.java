package com.example.homeservise;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homeservise.databinding.FragmentFeatureBinding;


public class FeatureFragment extends Fragment {
    FragmentFeatureBinding binding;


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
       return binding.getRoot();
    }
}