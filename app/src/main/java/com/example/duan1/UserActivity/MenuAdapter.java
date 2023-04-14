package com.example.duan1.UserActivity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.R;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {
    private List<Menu> menuList;


    public MenuAdapter(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public void setData(List<Menu> menuList) {
        this.menuList = menuList;
        notifyDataSetChanged();
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // lấy layout của menu item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_menu_item, parent, false);
        return new MenuViewHolder(view); // Trả về menu item view
    }

    private List<Menu> cartItemList = new ArrayList<>();
    public List<Menu> getCartItemList() {
        return cartItemList;
    }
    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        // gọi bên viewholder (lấy thành phần ánh xạ bên item) vào cái này để xử lý
        Menu menu = menuList.get(position);
        holder.imageView.setImageResource(menu.getImageResourceId());
        holder.foodNameTextView.setText(menu.getFoodName());
        holder.priceTextView.setText(menu.getPrice());

        holder.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartItemList.add(menu);
                Intent intent = new Intent(v.getContext(), UserMenuActivity.class);
                intent.putExtra("menuList", (Serializable) cartItemList);
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }
}

