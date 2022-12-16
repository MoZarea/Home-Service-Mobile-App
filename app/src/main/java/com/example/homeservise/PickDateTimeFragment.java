package com.example.homeservise;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homeservise.databinding.FragmentPickDateTimeBinding;

public class PickDateTimeFragment extends Fragment {
    FragmentPickDateTimeBinding binding;

    public PickDateTimeFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
binding=FragmentPickDateTimeBinding.inflate(inflater,container,false);
binding.toAddress.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //navigation to pickAddressFragment
        Navigation.findNavController(v).navigate(R.id.action_pickDateTimeFragment_to_pickAddressFragment);
    }
});
    return binding.getRoot();
    }
}