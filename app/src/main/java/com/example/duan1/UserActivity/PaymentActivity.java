package com.example.duan1.UserActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.duan1.R;
import com.example.duan1.adapter.PlaceYourOrderAdapter;

public class PaymentActivity extends AppCompatActivity {
    boolean status;

    private TextView tvTotalItems,tvSubtotal,tvSubtotalAmount,tvDeliveryCharge,tvDeliveryChargeAmount,tvTotal,tvTotalAmount;
    private TextView buttonPlaceYourOrder;
    private RecyclerView cartItemsRecyclerView;

    PlaceYourOrderAdapter placeYourOrderAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        tvTotalItems = findViewById(R.id.tvTotalItems);
        tvSubtotal = findViewById(R.id.tvSubtotal);
        tvSubtotalAmount = findViewById(R.id.tvSubtotalAmount);
        tvDeliveryCharge = findViewById(R.id.tvDeliveryCharge);
        tvDeliveryChargeAmount = findViewById(R.id.tvDeliveryChargeAmount);
        tvTotal = findViewById(R.id.tvTotal);
        tvTotalAmount = findViewById(R.id.tvTotalAmount);

        buttonPlaceYourOrder = findViewById(R.id.buttonPlaceYourOrder);

        cartItemsRecyclerView = findViewById(R.id.cartItemsRecyclerView);

        buttonPlaceYourOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PaymentActivity.this, OrderSucceessActivity.class);
            }
        });
    }
}