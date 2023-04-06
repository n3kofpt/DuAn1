package com.example.duan1.AdminActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.R;

public class MenuViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView foodNameTextView;
    public TextView priceTextView;

    public MenuViewHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.menu_item_image);
        foodNameTextView = itemView.findViewById(R.id.menu_item_food_name);
        priceTextView = itemView.findViewById(R.id.menu_item_price);
    }
}

