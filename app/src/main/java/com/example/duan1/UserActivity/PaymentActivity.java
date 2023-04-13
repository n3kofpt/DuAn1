package com.example.duan1.UserActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.duan1.R;

public class PaymentActivity extends AppCompatActivity {
    boolean status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        status = true;
        Reservation reservation = new Reservation(status);
    }
}