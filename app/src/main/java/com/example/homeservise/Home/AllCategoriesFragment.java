package com.example.homeservise.Home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homeservise.Domain.Category;
import com.example.homeservise.R;
import com.example.homeservise.adapters.CategoryAdapterAll;
import com.example.homeservise.adapters.ServicesAdapterAll;
import com.example.homeservise.databinding.FragmentAllCategoriesBinding;
import com.example.homeservise.databinding.FragmentAllServicesBinding;

import java.util.List;


public class AllCategoriesFragment extends Fragment {
    RecyclerView recyclerViewAllCat;
    CategoryViewModel categoryViewModel;
    CategoryAdapterAll categoryAdapterAll;
    FragmentAllCategoriesBinding binding;

    public AllCategoriesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAllCategoriesBinding.inflate(inflater, container, false);

        //////////////////////////////////////////////////////////
        /////// All Services Adapter with Recycler View /////////
        ////////////////////////////////////////////////////////
        recyclerViewAllCat =binding.recyclerViewAllCat;
        categoryAdapterAll=new CategoryAdapterAll(new OnItemClickListeners() {
            @Override
            public void onRndomCategoryClick(Category item, View view) {
                /*
                 * Navigation to To All Services and show data
                 * based on Category selected and pass data required to destination
                 */
                AllCategoriesFragmentDirections.ActionAllCategoriesFragmentToAllServicesFragment action =AllCategoriesFragmentDirections.actionAllCategoriesFragmentToAllServicesFragment(item.getTitel());
                Navigation.findNavController(view).navigate(action);
            }
        });
        recyclerViewAllCat.setLayoutManager(new GridLayoutManager(requireActivity(),3));
        recyclerViewAllCat.setHasFixedSize(true);
        recyclerViewAllCat.setAdapter(categoryAdapterAll);
        categoryViewModel=new ViewModelProvider(requireActivity()).get(CategoryViewModel.class);


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        categoryViewModel.getAllCategory().observe(requireActivity(), new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                categoryAdapterAll.setData(categories);
            }
        });
    }
}