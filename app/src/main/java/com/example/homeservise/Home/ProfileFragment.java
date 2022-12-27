package com.example.homeservise.Home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.homeservise.Data.User.UserData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homeservise.databinding.FragmentProfileBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ProfileFragment extends Fragment {
    FragmentProfileBinding binding;
    UserViewModel userViewModel;
    UserData current_user;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public ProfileFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        userViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);

        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*--------------->getting current user UID from firebase<---------------*/
        String UID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        /*--------------->get user data from local data base if exist<---------------*/
        userViewModel.getUserByUID(UID).observe(requireActivity(), new Observer<UserData>() {
            @Override
            public void onChanged(UserData userData) {
                current_user = userData;
                if (current_user != null) {
                    binding.nameUnderPic.setText(current_user.getName());

                    binding.emailUnderPic.setText(current_user.getEmail());
                    binding.name.setText(current_user.getName());
                    binding.email.setText(current_user.getEmail());
                    binding.phone.setText(current_user.getPhone());
                }
                else{
                    /*--------------->else..get data from firebase db<---------------*/
                    db.collection("new").document(FirebaseAuth.getInstance().getUid()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            current_user=documentSnapshot.toObject(UserData.class);
                            binding.nameUnderPic.setText(current_user.getName());

                            binding.emailUnderPic.setText(current_user.getEmail());
                            binding.name.setText(current_user.getName());
                            binding.email.setText(current_user.getEmail());
                            binding.phone.setText(current_user.getPhone());

                        }
                    });
                }

            }


        });

        /*--------------->update local and remote database with edited data<---------------*/
        binding.confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_user.setName(binding.name.getText().toString());
                current_user.setEmail(binding.email.getText().toString());
                current_user.setPhone(binding.phone.getText().toString());
                /*--------------->local<---------------*/
                userViewModel.update(current_user);
                /*--------------->remote<---------------*/
                db.collection("new").document(FirebaseAuth.getInstance().getUid()).set(current_user);


            }
        });

    }
}