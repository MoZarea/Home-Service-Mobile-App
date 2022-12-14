package com.example.homeservise.Home;

import android.app.DirectAction;
import android.app.Notification;
import android.content.Context;
import android.graphics.Path;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavAction;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homeservise.Domain.Category;
import com.example.homeservise.Domain.Services;
import com.example.homeservise.R;
import com.example.homeservise.adapters.CategoryAdapter;
import com.example.homeservise.adapters.ServicesAdapter;
import com.example.homeservise.databinding.FragmentHomeBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link HomeFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class HomeFragment extends Fragment {
    RecyclerView recyclerViewCat;
    RecyclerView recyclerViewSer;
    FragmentHomeBinding binding;
    CategoryViewModel categoryViewModel;
    ServicesViewModel servicesViewModel;
    CategoryAdapter categoryAdapter;
    ServicesAdapter servicesAdapter;
    BottomNavigationView navigationView;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
//    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding =  FragmentHomeBinding.inflate(inflater, container, false);

        categoryAdapter=new CategoryAdapter(new OnItemClickListeners() {
            @Override
            public void onRndomCategoryClick(Category item, View view) {
                HomeFragmentDirections.ActionHomeFragment2ToAllServicesFragment2 action =HomeFragmentDirections.actionHomeFragment2ToAllServicesFragment2(item.getPic());
                Navigation.findNavController(view).navigate(action);
            }
        });

        recyclerViewCat =binding.CatrecyclerView;
        recyclerViewCat.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recyclerViewCat.setHasFixedSize(true);
        recyclerViewCat.setAdapter(categoryAdapter);
        categoryViewModel= new ViewModelProvider(requireActivity()).get(CategoryViewModel.class);

        servicesAdapter=new ServicesAdapter(new OnServiceSelectedFromAll() {
            @Override
            public void onServiceSelected(Services services, View view) {
                HomeFragmentDirections.ActionHomeFragment2ToDetailsFragment action =HomeFragmentDirections.actionHomeFragment2ToDetailsFragment(services.getSertitle(),services.getSerCat(),services.getSerDiscribtion(),services.getSerPrice());
                Navigation.findNavController(view).navigate(action);

            }
        });
        recyclerViewSer=binding.Poprecycleview;
        recyclerViewSer.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recyclerViewSer.setHasFixedSize(true);
        recyclerViewSer.setAdapter(servicesAdapter);
        servicesViewModel=new ViewModelProvider(requireActivity()).get(ServicesViewModel.class);



        return binding.getRoot();
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        categoryViewModel.getAllCategory().observe(requireActivity(), new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                categoryAdapter.setData(categories);
            }
        });
        servicesViewModel.getAllServices().observe(requireActivity(), new Observer<List<Services>>() {
            @Override
            public void onChanged(List<Services> services) {
                servicesAdapter.setData(services);
            }
        });

        binding.showAllCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_homeFragment2_to_allCategoriesFragment2);
            }
        });
        binding.showAllServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragmentDirections.ActionHomeFragment2ToAllServicesFragment2 action =HomeFragmentDirections.actionHomeFragment2ToAllServicesFragment2(99);
                Navigation.findNavController(v).navigate(action);

            }
        });




    }



}