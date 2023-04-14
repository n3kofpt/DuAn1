package com.example.duan1.UserActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.duan1.R;

import java.util.List;

public class CartActivity extends AppCompatActivity {
    private List<Menu> cartItemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Intent intent = getIntent();
        cartItemList = (List<Menu>) intent.getSerializableExtra("cartItemList");

        // hiển thị các mục trong giỏ hàng
//        for (Menu menu : cartItemList) {
//            Log.d("Cart", menu.getFoodName() + " - " + menu.getPrice());
//        }

        RecyclerView recyclerView = findViewById(R.id.cart_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (cartItemList != null) {
            recyclerView.setAdapter(new CartAdapter(cartItemList));
        }
    }
}