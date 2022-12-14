package com.example.homeservise;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homeservise.databinding.FragmentDetailsBinding;

public class DetailsFragment extends Fragment {
    FragmentDetailsBinding binding;
    DetailsFragmentArgs args;

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
        args=DetailsFragmentArgs.fromBundle(getArguments());
        binding.title.setText(args.getTitle());
        binding.categoty.setText(args.getCatTitle());
        binding.details.setText(args.getDescribtion());
        binding.price.setText(args.getPrice());

        binding.book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_detailsFragment_to_pickDateTimeFragment);
            }
        });

        return binding.getRoot();
    }
}