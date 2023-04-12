package com.example.duan1.UserActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.R;


import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {
    private List<Menu> menuList;

    public interface ItemClickListener {
        void onClick(View view, int position,boolean isLongClick);
    }

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

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        // gọi bên viewholder (lấy thành phần ánh xạ bên item) vào cái này để xử lý
        Menu menu = menuList.get(position);
        holder.imageView.setImageResource(menu.getImageResourceId());
        holder.foodNameTextView.setText(menu.getFoodName());
        holder.priceTextView.setText(menu.getPrice());
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }
}

