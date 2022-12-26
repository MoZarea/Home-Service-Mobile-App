package com.example.homeservise.Home;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homeservise.Data.User.UserData;
import com.example.homeservise.databinding.FragmentSuggestBinding;
import com.google.firebase.firestore.FirebaseFirestore;

public class Suggest extends Fragment {
    FragmentSuggestBinding binding;


    public Suggest() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Intent sendIntent = new Intent();
        String  number= "+201150191031";
        startActivity(
                new Intent(Intent.ACTION_VIEW,
                        Uri.parse(
                                String.format("https://api.whatsapp.com/send?phone=%s&text=%s", number, "قدم لنا ملاحظاتك او اى شكاوي او مشكلات واجهتها لنتمكن من تحسين الخدمة المقدمة اليكم")
                        )
                )
        );
        getActivity().getSupportFragmentManager().popBackStack();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentSuggestBinding.inflate(inflater,null,false);
        return binding.getRoot();


    }
}