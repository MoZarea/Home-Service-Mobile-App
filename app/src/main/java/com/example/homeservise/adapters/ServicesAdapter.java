package com.example.homeservise.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.homeservise.Domain.Services;
import com.example.homeservise.R;

import java.util.ArrayList;
import java.util.List;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.Viewholderpop> {
    List<Services> services=new ArrayList<>();

    public ServicesAdapter() {

    }



    @NonNull
    @Override
    public Viewholderpop onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_item,parent,false);
        return new Viewholderpop(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholderpop holder, int position) {
        Services current_service =services.get(position);
        holder.tvSerTitle.setText(current_service.getSertitle());
        holder.tv_Serprice.setText(current_service.getSerPrice());
        holder.Serimage.setImageResource(current_service.getSerPic());



    }

    @Override
    public int getItemCount() {
        int max=5;
        if(services.size()<max){
            return services.size();
        }
        else{return max;}
    }

    public class Viewholderpop extends RecyclerView.ViewHolder{
        TextView  tvSerTitle,tv_Serprice;
        ImageView Serimage;
        public Viewholderpop(@NonNull View itemView) {
            super(itemView);
            tvSerTitle = itemView.findViewById(R.id.serTitle);
            tv_Serprice = itemView.findViewById(R.id.SerPrice);
            Serimage = itemView.findViewById(R.id.SerPic);

        }
    }
    public void setData(List<Services> services) {
        this.services = services;
        notifyDataSetChanged();
    }

}