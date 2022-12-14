package com.example.homeservise.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homeservise.Domain.Services;
import com.example.homeservise.Home.OnItemClickListeners;
import com.example.homeservise.Home.OnServiceSelectedFromAll;
import com.example.homeservise.R;

import java.util.ArrayList;
import java.util.List;

public class ServicesAdapterAll extends RecyclerView.Adapter<ServicesAdapterAll.Viewholderpop> {
    List<Services> services=new ArrayList<>();
    OnServiceSelectedFromAll listeners;
    public ServicesAdapterAll(OnServiceSelectedFromAll listeners) {
        this.listeners=listeners;

    }



    @NonNull
    @Override
    public Viewholderpop onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.services_item_vertival_for_all,parent,false);
        return new Viewholderpop(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholderpop holder, int position) {
        Services current_service =services.get(position);
        holder.bind(current_service);



    }

    @Override
    public int getItemCount() {
      return services.size();
    }

    public class Viewholderpop extends RecyclerView.ViewHolder{
        TextView  tvSerTitle,tv_Serprice;
        ImageView Serimage;
        Services services;
        public Viewholderpop(@NonNull View itemView) {
            super(itemView);
            tvSerTitle = itemView.findViewById(R.id.serTitle);
            tv_Serprice = itemView.findViewById(R.id.SerPrice);
            Serimage = itemView.findViewById(R.id.SerPic);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listeners.onServiceSelected(services,itemView);
                }
            });

        }
        void bind(Services services){
            this.services=services;
            tvSerTitle.setText(services.getSertitle());
            tv_Serprice.setText(services.getSerPrice());
            Serimage.setImageResource(services.getSerPic());
        }
    }
    public void setData(List<Services> services) {
        this.services = services;
        notifyDataSetChanged();
    }

}