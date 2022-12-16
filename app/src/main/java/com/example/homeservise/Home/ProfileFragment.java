package com.example.homeservise.Home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.homeservise.Domain.UserData;
import com.example.homeservise.R;
import com.example.homeservise.databinding.FragmentPreferedBinding;
import com.example.homeservise.databinding.FragmentProfileBinding;

import java.util.List;


public class ProfileFragment extends Fragment {
    FragmentProfileBinding binding;
    UserViewModel userViewModel;
    int primaryKey;
    int wallet;
    UserData userData2;



    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentProfileBinding.inflate(inflater,container,false);
        userViewModel=new ViewModelProvider(requireActivity()).get(UserViewModel.class);

        return  binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userViewModel.getUserOne().observe(requireActivity(), new Observer<List<UserData>>() {
            @Override
            public void onChanged(List<UserData> userData) {
                userData2=userData.get(0);
                binding.nameUnderPic.setText(userData.get(0).getName());
                binding.emailUnderPic.setText(userData.get(0).getEmail());
                binding.name.setText(userData.get(0).getName());
                binding.email.setText(userData.get(0).getEmail());
                binding.phone.setText(userData.get(0).getPhone());
                binding.address.setText(userData.get(0).getAddress());
            }
        });
        binding.confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userData2.setName(binding.name.getText().toString());
                userData2.setEmail(binding.email.getText().toString());
                userData2.setPhone(binding.phone.getText().toString());
                userData2.setAddress(binding.address.getText().toString());
                userViewModel.update(userData2);

            }
        });

    }
}