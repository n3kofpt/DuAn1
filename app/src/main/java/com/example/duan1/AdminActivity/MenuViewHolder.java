package com.example.duan1.AdminActivity;

import android.app.Application;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.R;

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    public ImageView imageView;
    public TextView foodNameTextView;
    public TextView priceTextView;

    private MenuAdapter.ItemClickListener itemClickListener;  // Khai báo interface

    public MenuViewHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.menu_item_image);
        foodNameTextView = itemView.findViewById(R.id.menu_item_food_name);
        priceTextView = itemView.findViewById(R.id.menu_item_price);

        itemView.setOnClickListener(this); // Mấu chốt ở đây , set sự kiên onClick cho View
        itemView.setOnLongClickListener(this); // Mấu chốt ở đây , set sự kiên onLongClick cho View
    }

    //Tạo setter cho biến itemClickListenenr
    public void setItemClickListener(MenuAdapter.ItemClickListener itemClickListener)
    {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),false);
    }

    @Override
    public boolean onLongClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),true);
        return true;
    }
}

