package com.example.homeservise.Home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homeservise.Domain.Services;
import com.example.homeservise.R;
import com.example.homeservise.adapters.CategoryAdapter;
import com.example.homeservise.adapters.ServicesAdapter;
import com.example.homeservise.adapters.ServicesAdapterAll;
import com.example.homeservise.databinding.FragmentAllServicesBinding;
import com.example.homeservise.databinding.FragmentHomeBinding;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AllServicesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AllServicesFragment extends Fragment {
    RecyclerView recyclerViewAllSer;
    CategoryViewModel categoryViewModel;
    ServicesViewModel servicesViewModel;
    ServicesAdapterAll servicesAdapterAll;
    AllServicesFragmentArgs args;
    FragmentAllServicesBinding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AllServicesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AllServicesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AllServicesFragment newInstance(String param1, String param2) {
        AllServicesFragment fragment = new AllServicesFragment();
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

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAllServicesBinding.inflate(inflater, container, false);
        args = AllServicesFragmentArgs.fromBundle(getArguments());
        recyclerViewAllSer = binding.recyclerViewAllServices;
        servicesAdapterAll = new ServicesAdapterAll(new OnServiceSelectedFromAll() {
            @Override
            public void onServiceSelected(Services services, View view) {
                //todo/////////////////////////////////////////////////////
            }
        });
        recyclerViewAllSer.setLayoutManager(new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerViewAllSer.setHasFixedSize(true);
        recyclerViewAllSer.setAdapter(servicesAdapterAll);
        servicesViewModel = new ViewModelProvider(requireActivity()).get(ServicesViewModel.class);

        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int cat = args.getCAT();

        //todo كمل باقي الفئات والدوال بتاعتها من هنا
        if (cat == R.drawable.broom) {
            servicesViewModel.getAllCleanWorker().observe(requireActivity(), new Observer<List<Services>>() {
                @Override

                public void onChanged(List<Services> services) {
                    servicesAdapterAll.setData(services);
                }
            });
        }
        if (cat == R.drawable.electrician) {
            servicesViewModel.getAllElictricalWorker().observe(requireActivity(), new Observer<List<Services>>() {
                @Override

                public void onChanged(List<Services> services) {
                    servicesAdapterAll.setData(services);
                }
            });
        }
        if (cat == R.drawable.plumber) {
            servicesViewModel.getAllPlumberWorker().observe(requireActivity(), new Observer<List<Services>>() {
                @Override

                public void onChanged(List<Services> services) {
                    servicesAdapterAll.setData(services);
                }
            });
        }
        if (cat == R.drawable.carpenter) {
            servicesViewModel.getAllCarpenterWorker().observe(requireActivity(), new Observer<List<Services>>() {
                @Override

                public void onChanged(List<Services> services) {
                    servicesAdapterAll.setData(services);
                }
            });
        }
        if (cat == 99) {
            servicesViewModel.getAllServices().observe(requireActivity(), new Observer<List<Services>>() {
                @Override

                public void onChanged(List<Services> services) {
                    servicesAdapterAll.setData(services);
                }
            });
        }




    }
}