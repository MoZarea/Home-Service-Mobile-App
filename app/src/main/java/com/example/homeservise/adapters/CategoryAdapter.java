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


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CATviewHolder> {
    List<Category> cat =new ArrayList<>();
    OnItemClickListeners listeners;
    public CategoryAdapter(OnItemClickListeners listeners) {
        this.listeners=listeners;

    }

    @NonNull
    @Override
    public CATviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);

        return new CATviewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CATviewHolder holder, int position) {
            Category currentCat =cat.get(position);
            holder.bind(currentCat);




    }


    @Override
    public int getItemCount() {
        int max=5;
        if(cat.size()<max){
            return cat.size();
        }
        else{return max;}
    }

    public class CATviewHolder extends RecyclerView.ViewHolder{
        TextView tv_name;
        ImageView iv_image;
        Category category;
        public CATviewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.catTitle);
            iv_image=itemView.findViewById(R.id.catPic);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listeners.onRndomCategoryClick(category,itemView);
                }
            });

        }
        void bind(Category category){
            this.category=category;
            tv_name.setText(category.getTitel());
            iv_image.setImageResource(category.getPic());
        }
    }

    public void setData(List<Category> cat) {
        this.cat = cat;
        notifyDataSetChanged();
    }

}
