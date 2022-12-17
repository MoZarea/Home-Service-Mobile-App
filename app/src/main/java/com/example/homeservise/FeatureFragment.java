package com.example.homeservise;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import com.example.homeservise.Domain.Oders;
import com.example.homeservise.Home.ServicesViewModel;
import com.example.homeservise.databinding.FragmentFeatureBinding;
import com.google.android.material.chip.ChipGroup;

import java.util.List;


public class FeatureFragment extends Fragment {
    FragmentFeatureBinding binding;
    ServicesViewModel servicesViewModel;
    ChipGroup num_of_pieces_CG,extra_CG;
    FeatureFragmentArgs args;
    RadioGroup radioGroup;
    Oders order;

    String instanse2 = null;
    int total_room_cost;
    int num_of_pieces;
    int total_extra_cost;
    String text_flat_is_closed;
    int num_of_extras;
    String special_cleaning;



    public FeatureFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding=FragmentFeatureBinding.inflate(inflater,container,false);
       args=FeatureFragmentArgs.fromBundle(getArguments());

       servicesViewModel=new ViewModelProvider(requireActivity()).get(ServicesViewModel.class);
       num_of_pieces_CG =binding.room;
       extra_CG=binding.extras;
       radioGroup=binding.radioGroup;
       num_of_pieces_CG.setOnCheckedStateChangeListener(new ChipGroup.OnCheckedStateChangeListener() {
           @Override
           public void onCheckedChanged(@NonNull ChipGroup group, @NonNull List<Integer> checkedIds) {
               int checked=num_of_pieces_CG.getCheckedChipId();
               if(checked==R.id.up_to_7){
                   num_of_pieces=7;
                   total_room_cost=0;
                   binding.totalCost.setText((args.getService().getSer_Price()+total_room_cost+ total_extra_cost)+"");

               }
               else if(checked==R.id.up_to_8){
                   num_of_pieces=8;
                   total_room_cost=20;
                   binding.totalCost.setText((args.getService().getSer_Price()+total_room_cost+ total_extra_cost)+"");

               }
               else if(checked==R.id.up_to_9){
                   num_of_pieces=9;
                   total_room_cost=40;
                   binding.totalCost.setText((args.getService().getSer_Price()+total_room_cost+ total_extra_cost)+"");

               }
           }
       });




       radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {
               if (checkedId==R.id.closed){

                   text_flat_is_closed ="الشقة مغلقة : لا";
               }
               else{
                   text_flat_is_closed ="الشقة مغلقة : نعم ";
               }
           }
       });
       binding.spehialCleaning.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(isChecked){
                   special_cleaning="آثار تشطيب : نعم ";
               }
               else{
                   special_cleaning="آثار تشطيب : لا ";

               }
           }
       });
       extra_CG.setOnCheckedStateChangeListener(new ChipGroup.OnCheckedStateChangeListener() {
           @Override
           public void onCheckedChanged(@NonNull ChipGroup group, @NonNull List<Integer> checkedIds) {


           }
       });

       extra_CG.setOnCheckedStateChangeListener(new ChipGroup.OnCheckedStateChangeListener() {
           @Override
           public void onCheckedChanged(@NonNull ChipGroup group, @NonNull List<Integer> checkedIds) {
                total_extra_cost=((checkedIds.size())*50)  ;
                num_of_extras=checkedIds.size();
               binding.totalCost.setText((args.getService().getSer_Price()+total_room_cost+ total_extra_cost)+"");
           }
       });

       return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.totalCost.setText((args.getService().getSer_Price()+total_room_cost+ total_extra_cost)+"");

        binding.confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                args.getOrder().setNotes(get_text_for_noteString());
                args.getOrder().setTotalCost(args.getService().getSer_Price()+total_room_cost+ total_extra_cost);
                args.getOrder().setServiceID(args.getService().getId());
                args.getOrder().setSer_title(args.getService().getSertitle());
                args.getOrder().setCat_title(args.getService().getSerCat());
                FeatureFragmentDirections.ActionFeatureFragmentToPickDateTimeFragment action =FeatureFragmentDirections.actionFeatureFragmentToPickDateTimeFragment(args.getService(),args.getOrder());
                Navigation.findNavController(v).navigate(action);
            }
        });



    }




    public String get_text_for_noteString(){
        String room_text ="عدد القطع حتي : ";

        String extra_text ="عدد الخدمات الاضافية : ";

        String cost=" التكلفة ";

        instanse2=room_text+num_of_pieces+"\t";
        instanse2=instanse2+cost+total_room_cost+"\n";

        instanse2=instanse2+text_flat_is_closed+"\n";

        instanse2=instanse2+special_cleaning+"\n";

        instanse2=instanse2+extra_text+num_of_extras+"\t";
        instanse2=instanse2+cost+total_extra_cost+"\n";

        return instanse2;
    }
}