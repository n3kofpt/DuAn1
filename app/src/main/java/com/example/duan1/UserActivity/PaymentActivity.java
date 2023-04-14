package com.example.duan1.UserActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.duan1.R;
import com.example.duan1.adapter.PlaceYourOrderAdapter;

    public class PaymentActivity extends AppCompatActivity {
        boolean status;
        Reservation reservation = new Reservation(status);
        TextView tvTotalItems, tvSubtotal, tvSubtotalAmount, tvDeliveryCharge, tvDeliveryChargeAmount, tvTotal, tvTotalAmount;
        TextView buttonPlaceYourOrder;
        RecyclerView cartItemsRecyclerView;

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
            initRecyclerView(reservation);
            buttonPlaceYourOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(PaymentActivity.this, OrderSucceessActivity.class);
                    startActivity(i);
                    isChecked(status);
                }
            });



        }
    private void calculateTotalAmount(Reservation reservation) {
        String subTotalAmount = 0+"";
        // lay tong gia tien
        for(Menu m : reservation.getMenus()) {
            subTotalAmount += m.getPrice();
        }

        tvSubtotalAmount.setText("$"+String.format("%.2f", subTotalAmount));
        tvTotalAmount.setText("$"+String.format("%.2f", subTotalAmount));
    }
    private void initRecyclerView(Reservation reservation) {
        cartItemsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        placeYourOrderAdapter = new PlaceYourOrderAdapter(reservation.getMenus());
        cartItemsRecyclerView.setAdapter(placeYourOrderAdapter);
    }

    public void isChecked(boolean isCheck){
        if(isCheck = true){
            status = true;
            status = reservation.isStatus();
            reservation = new Reservation(status);
            Intent i = new Intent(PaymentActivity.this, OrderSucceessActivity.class);
            startActivity(i);

        }else {
            status = false;
            status = reservation.isStatus();
            reservation = new Reservation(status);
        }
    }
}