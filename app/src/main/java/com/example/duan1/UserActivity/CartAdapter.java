package com.example.duan1.UserActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.R;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private List<Menu> cartItemList;

    public CartAdapter(List<Menu> cartItemList) {
        this.cartItemList = cartItemList;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new CartViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Menu menu = cartItemList.get(position);
        holder.cart_item_food_name.setText(menu.getFoodName());
        holder.cart_item_price.setText(menu.getPrice());
    }

    @Override
    public int getItemCount() {
        return cartItemList.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView cart_item_image;
        TextView cart_item_food_name;
        TextView cart_item_price;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            cart_item_image = itemView.findViewById(R.id.cart_item_image);
            cart_item_food_name = itemView.findViewById(R.id.cart_item_food_name);
            cart_item_price = itemView.findViewById(R.id.cart_item_price);
        }
    }
}
