package com.example.duan1.UserActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.duan1.R;
import com.example.duan1.adapter.PlaceYourOrderAdapter;

    public class PaymentActivity extends AppCompatActivity {
        boolean status;
        TextView tvTotalItems, tvSubtotal, tvSubtotalAmount, tvDeliveryCharge, tvDeliveryChargeAmount, tvTotal, tvTotalAmount;
        TextView buttonPlaceYourOrder;
        RecyclerView cartItemsRecyclerView;

        EditText edt_PayMoney;

        PlaceYourOrderAdapter placeYourOrderAdapter;

        Reservation reservation;



        @SuppressLint("MissingInflatedId")
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

            edt_PayMoney = findViewById(R.id.edt_PayMoney);


            calculateTotalAmount(reservation);
            buttonPlaceYourOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    isChecked();
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
    public void isChecked(){
            Double d = Double.valueOf(edt_PayMoney.getText().toString());
            String subTotalAmount = 0+"";
            // lay tong gia tien
            for(Menu m : reservation.getMenus()) {
                subTotalAmount += m.getPrice();
            }
            Double subT = Double.valueOf(subTotalAmount);
            if(edt_PayMoney.length()==0){
                edt_PayMoney.requestFocus();
                edt_PayMoney.setError("Không được bỏ trống");
            }else if(d >= (subT/10)) {
                // truyền dữ liệu
                Intent i = new Intent(PaymentActivity.this, OrderSucceessActivity.class);
                startActivity(i);
            }
        }
    }
