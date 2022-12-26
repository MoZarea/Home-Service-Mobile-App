package com.example.homeservise.Home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.homeservise.Home.ServicesViewModel;
import com.example.homeservise.R;
import com.example.homeservise.databinding.FragmentPickAddressBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class PickAddressFragment extends Fragment {
    FragmentPickAddressBinding binding;
    PickAddressFragmentArgs args;
    String address1 ;
    String address2 ;
    String address3 ;
    String address4 ;
    String address5 ;
    String address6 ;
    ServicesViewModel servicesViewModel;



    public PickAddressFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPickAddressBinding.inflate(inflater, container, false);
        servicesViewModel=new ViewModelProvider(requireActivity()).get(ServicesViewModel.class);
        args = PickAddressFragmentArgs.fromBundle(getArguments());
        binding.address1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.Adderss1Layout.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(s)){
                    binding.Adderss1Layout.setError("ادخل المحافظة");
                    address1=null;
                }
                else{
                    binding.Adderss1Layout.setError(null);
                    address1=s.toString();

                }

            }
        });
        binding.address2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.Adderss1Layout.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(s)){
                    binding.Adderss2Layout.setError("ادخل المنطقة");
                    address2=null;

                }
                else{
                    binding.Adderss2Layout.setError(null);
                    address2=s.toString();
                }
            }
        });
        binding.address3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.Adderss1Layout.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(s)){
                    binding.Adderss3Layout.setError("ادخل الشارع");
                    address3=null;
                }
                else{
                    binding.Adderss1Layout.setError(null);
                    address3=s.toString();
                }

            }
        });
        binding.address4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.Adderss1Layout.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(s)){
                    binding.Adderss4Layout.setError("ادخل العلامة المميزة");
                    address4=null;
                }
                else{
                    binding.Adderss1Layout.setError(null);
                    address4=s.toString();
                }

            }
        });
        binding.address5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.Adderss1Layout.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(s)){
                    binding.Adderss5Layout.setError("ادخل رقم العمارة");
                    address5=null;
                }
                else{
                    binding.Adderss5Layout.setError(null);
                    address5=s.toString();
                }

            }
        });
        binding.address6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.Adderss1Layout.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(s)){
                    binding.Adderss6Layout.setError("ادخل رقم الشقة");
                    address6=null;
                }
                else{
                    binding.Adderss6Layout.setError(null);
                    address6=s.toString();
                }

            }
        });
        binding.toFinalOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(address1==null ||
                    address2==null||
                    address3==null||
                address4==null||
                address5==null||
                address6==null)
                {
                    Toast.makeText(getActivity(), "اكمل الحقول الفارغة", Toast.LENGTH_SHORT).show();
                }
                else{
                    args.getOrder().setParticular_address(address1+" , "+address2);
                    args.getOrder().setTotal_address(address1+" , "+address2);
                    servicesViewModel.insert(args.getOrder());
                    Navigation.findNavController(v).navigate(R.id.homeFragment2);
                    Navigation.findNavController(v).navigate(R.id.ordersFragment);
                }
            }
        });


        return binding.getRoot();
    }
}