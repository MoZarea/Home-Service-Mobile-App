package com.example.homeservise.Home;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.homeservise.databinding.FragmentPickDateTimeBinding;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.List;

public class PickDateTimeFragment extends Fragment {
    FragmentPickDateTimeBinding binding;
    PickDateTimeFragmentArgs args;
    DatePicker datePicker;
    String date;
    String time;
    ChipGroup chipGroup;

    public PickDateTimeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPickDateTimeBinding.inflate(inflater, container, false);
        args = PickDateTimeFragmentArgs.fromBundle(getArguments());
        /*--------------->get regerence<---------------*/
        datePicker = binding.calenderv;
        chipGroup = binding.chipGroup;
        /*--------------->get data from user<---------------*/
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    date = year+ "/" +monthOfYear+ "/" +dayOfMonth;
                }
            });
            /*--------------->min date in current date<---------------*/
            datePicker.setMinDate(System.currentTimeMillis());
        }
        /*--------------->get time from user<---------------*/
        chipGroup.setOnCheckedStateChangeListener(new ChipGroup.OnCheckedStateChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull ChipGroup group, @NonNull List<Integer> checkedIds) {
                int selected_time=chipGroup.getCheckedChipId();
                Chip chip=group.findViewById(selected_time);
                time=chip.getText().toString();

            }
        });


        binding.toAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*--------------->make sure nothing null<---------------*/
                if(date==null||time==null){
                    Toast.makeText(getActivity(), "التاريخ او الوقت  لم يتم تحديدهم بعد  ", Toast.LENGTH_SHORT).show();
                }
                else{

                args.getOrder().setDate(date);
                args.getOrder().setTime(time);
                //navigation to pickAddressFragment
                PickDateTimeFragmentDirections.ActionPickDateTimeFragmentToPickAddressFragment action =PickDateTimeFragmentDirections.actionPickDateTimeFragmentToPickAddressFragment(args.getService(),args.getOrder());
                Navigation.findNavController(v).navigate(action);
            }}
        });
        return binding.getRoot();
    }
}