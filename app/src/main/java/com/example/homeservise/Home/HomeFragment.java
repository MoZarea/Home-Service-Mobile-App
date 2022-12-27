package com.example.homeservise.Home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homeservise.Data.Category.Category;
import com.example.homeservise.Data.Service.Services;
import com.example.homeservise.R;
import com.example.homeservise.adapters.CategoryAdapter;
import com.example.homeservise.adapters.ServicesAdapter;
import com.example.homeservise.databinding.FragmentHomeBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;


public class HomeFragment extends Fragment {
    RecyclerView recyclerViewCat;
    RecyclerView recyclerViewSer;
    FragmentHomeBinding binding;
    CategoryViewModel categoryViewModel;
    ServicesViewModel servicesViewModel;
    CategoryAdapter categoryAdapter;
    ServicesAdapter servicesAdapter;
    BottomNavigationView navigationView;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding =  FragmentHomeBinding.inflate(inflater, container, false);
        /*--------------->adapter binding<---------------*/
        categoryAdapter=new CategoryAdapter(new OnItemClickListeners() {
            @Override
            public void onRndomCategoryClick(Category item, View view) {
                /*
                 * Navigation to all Services fragment and show data
                 * based on category selected and pass data required to destination
                */
                HomeFragmentDirections.ActionHomeFragment2ToAllServicesFragment2 action =HomeFragmentDirections.actionHomeFragment2ToAllServicesFragment2(item.getTitel());
                Navigation.findNavController(view).navigate(action);
            }
        });
        recyclerViewCat =binding.CatrecyclerView;
        recyclerViewCat.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recyclerViewCat.setHasFixedSize(true);
        recyclerViewCat.setAdapter(categoryAdapter);
        categoryViewModel= new ViewModelProvider(requireActivity()).get(CategoryViewModel.class);


        /*--------------->adapter binding <---------------*/
        servicesAdapter=new ServicesAdapter(new OnServiceSelectedFromAll() {
            @Override
            public void onServiceSelected(Services services, View view) {
                /*
                 * Navigation to Details Fragment and show data
                 * based on servise selected and pass data required to destination
                 */                HomeFragmentDirections.ActionHomeFragment2ToDetailsFragment action =HomeFragmentDirections.actionHomeFragment2ToDetailsFragment(services);
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
        /*--------------->update adapter with data<---------------*/
        categoryViewModel.getAllCategory().observe(requireActivity(), new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                categoryAdapter.setData(categories);
            }
        });
        /*--------------->update adapter with data<---------------*/
        servicesViewModel.getAllServices().observe(requireActivity(), new Observer<List<Services>>() {
            @Override
            public void onChanged(List<Services> services) {
                servicesAdapter.setData(services);
            }
        });
        /*--------------->navigation to net fragment<---------------*/

        binding.showAllCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_homeFragment2_to_allCategoriesFragment2);
            }
        });
        /*
         * navigation to all Services Fragment when button clicked
         * with param 99 to tell the destination to show all services
         */
        binding.showAllServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragmentDirections.ActionHomeFragment2ToAllServicesFragment2 action =HomeFragmentDirections.actionHomeFragment2ToAllServicesFragment2("99");
                Navigation.findNavController(v).navigate(action);
            }
        });
    }
}