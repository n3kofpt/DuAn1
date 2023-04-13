package com.example.duan1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.R;
import com.example.duan1.UserActivity.Menu;

import java.util.List;

public class PlaceYourOrderAdapter extends RecyclerView.Adapter<PlaceYourOrderAdapter.MyViewHolder> {

    private List<Menu> menuList;

    public PlaceYourOrderAdapter(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public void updateData(List<Menu> menuList) {
        this.menuList = menuList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_order_recycler_row, parent, false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.menuName.setText(menuList.get(position).getFoodName());
        holder.menuPrice.setText(menuList.get(position).getPrice().toString());
        holder.thumbImage.setImageResource(menuList.get(position).getImageResourceId());

    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView  menuName;
        TextView  menuPrice;
        ImageView thumbImage;

        public MyViewHolder(View view) {
            super(view);
            menuName = view.findViewById(R.id.menuName);
            menuPrice = view.findViewById(R.id.menuPrice);
            thumbImage = view.findViewById(R.id.thumbImage);
        }
    }
}
