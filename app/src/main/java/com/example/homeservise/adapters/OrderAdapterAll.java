package com.example.homeservise.adapters;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homeservise.Data.Order.Orders;
import com.example.homeservise.Listener.Order.OrderOneValueListener;
import com.example.homeservise.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderAdapterAll extends RecyclerView.Adapter<OrderAdapterAll.Viewholderpop> {
    List<Orders> order=new ArrayList<>();
    OrderOneValueListener listeners;
    public OrderAdapterAll(OrderOneValueListener listeners) {
        this.listeners=listeners;

    }



    @NonNull
    @Override
    public Viewholderpop onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.pending_order_item,parent,false);
        return new Viewholderpop(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholderpop holder, int position) {
        Orders current_order =order.get(position);
        holder.bind(current_order);

    }

    @Override
    public int getItemCount() {
      return order.size();
    }

    public class Viewholderpop extends RecyclerView.ViewHolder{
        TextView order_time, order_date, order_cost ,order_address ,order_number,today_date ,order_ser_title, order_category;
        Orders oders;
        public Viewholderpop(@NonNull View itemView) {
            super(itemView);
            order_time = itemView.findViewById(R.id.order_time);
            order_date = itemView.findViewById(R.id.order_date);
            order_cost = itemView.findViewById(R.id.order_cost);
            order_address = itemView.findViewById(R.id.order_address);
            order_number = itemView.findViewById(R.id.order_number);
            today_date = itemView.findViewById(R.id.today_date);
            order_ser_title = itemView.findViewById(R.id.order_ser_title);
            order_category = itemView.findViewById(R.id.order_category);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    listeners.onValueSubmit(oders,itemView);
                }
            });
        }
        void bind(Orders orders){
            this.oders =orders;
            order_time.setText(orders.getTime());
            order_date.setText(orders.getDate());
            order_cost.setText(orders.getTotalCost()+" ج ");
            order_address.setText(orders.getParticular_address());
            order_number.setText("اوردر رقم: "+orders.getOrderID()+"");

            Date d = new Date();
            CharSequence s  = DateFormat.format("MMMM d, yyyy ", d.getTime());
            today_date.setText(s);

            order_ser_title.setText(orders.getSer_title());
            order_category.setText("الخدمة: "+orders.getCat_title());
        }
    }
    public void setData(List<Orders> orders) {
        this.order = orders;
        notifyDataSetChanged();
    }

}