package com.example.homeservise.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homeservise.Data.Category.Category;
import com.example.homeservise.Home.OnItemClickListeners;
import com.example.homeservise.R;

import java.util.ArrayList;
import java.util.List;


public class CategoryAdapterAll extends RecyclerView.Adapter<CategoryAdapterAll.CATviewHolder> {
    /*-----> List to save incoming data <------*/
    List<Category> cat =new ArrayList<>();
    /*---->listener for item click<---------*/
    OnItemClickListeners listeners;
    /*--------------->constructor with listener as a parameter<---------------*/
    public CategoryAdapterAll(OnItemClickListeners listeners) {
        this.listeners=listeners;

    }
    /*---------------> on create method to inflate item layout<---------------*/
    @NonNull
    @Override
    public CATviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);

        return new CATviewHolder(v);
    }
    /*--------------->get position for item wanted in recycler view<---------------*/
    @Override
    public void onBindViewHolder(@NonNull CATviewHolder holder, int position) {
            Category currentCat =cat.get(position);
            holder.bind(currentCat);




    }

    /*--------------->get count of data that will be show in RV<---------------*/
    @Override
    public int getItemCount() {
       return cat.size();
    }
    /*--------------->getting reference to views and bind data to it<---------------*/
    public class CATviewHolder extends RecyclerView.ViewHolder{
        TextView tv_name;
        ImageView iv_image;
        Category category;


        public CATviewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.catTitle);
            iv_image=itemView.findViewById(R.id.catPic);
            /*--------------->send data to listener in activity<---------------*/
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listeners.onRndomCategoryClick(category,itemView);
                }
            });

        }
        /*--------------->data binding<---------------*/
        void bind(Category category){
            this.category=category;
            tv_name.setText(category.getTitel());
            iv_image.setImageResource(category.getPic());
        }
    }
    /*--------------->get updated data from database<---------------*/
    public void setData(List<Category> cat) {
        this.cat = cat;
        notifyDataSetChanged();
    }

}
