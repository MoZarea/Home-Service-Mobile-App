package com.example.homeservise.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.homeservise.Data.Service.Services;
import com.example.homeservise.Home.OnServiceSelectedFromAll;
import com.example.homeservise.R;

import java.util.ArrayList;
import java.util.List;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.Viewholderpop> {
    /*-----> List to save incoming data <------*/
    List<Services> services=new ArrayList<>();
    /*---->listener for item click<---------*/
    OnServiceSelectedFromAll listener;
    /*--------------->constructor with listener as a parameter<---------------*/
    public ServicesAdapter(OnServiceSelectedFromAll listener) {
        this.listener=listener;

    }
    /*---------------> on create method to inflate item layout<---------------*/
    @NonNull
    @Override
    public Viewholderpop onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_item,parent,false);
        return new Viewholderpop(v);
    }
    /*--------------->get position for item wanted in recycler view<---------------*/
    @Override
    public void onBindViewHolder(@NonNull Viewholderpop holder, int position) {
        Services current_service =services.get(position);
        holder.bind(current_service);

    }
    /*--------------->get count of data that will be show in RV<---------------*/
    @Override
    public int getItemCount() {
        int max=5;
        if(services.size()<max){
            return services.size();
        }
        else{return max;}
    }
    /*--------------->getting reference to views and bind data to it<---------------*/
    public class Viewholderpop extends RecyclerView.ViewHolder{
        TextView  tvSerTitle,tv_Serprice;
        ImageView Serimage;
        Services services;

        public Viewholderpop(@NonNull View itemView) {
            super(itemView);
            tvSerTitle = itemView.findViewById(R.id.serTitle);
            tv_Serprice = itemView.findViewById(R.id.SerPrice);
            Serimage = itemView.findViewById(R.id.SerPic);

            /*--------------->send data to listener in activity<---------------*/
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onServiceSelected(services,itemView);

                }
            });

        }
        /*--------------->data binding<---------------*/
        void bind(Services services){
            this.services=services;
            tvSerTitle.setText(services.getSertitle());
            tv_Serprice.setText(services.getSerPrice());
            Serimage.setImageResource(services.getSerPic());
//
        }
    }
    /*--------------->get updated data from database<---------------*/
    public void setData(List<Services> services) {
        this.services = services;
        notifyDataSetChanged();
    }

}