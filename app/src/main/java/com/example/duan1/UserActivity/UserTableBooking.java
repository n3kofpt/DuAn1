package com.example.duan1.UserActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.duan1.R;

public class UserTableBooking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_table_booking);

    }
    public void onImageClick(View view) {
        Intent intent = new Intent(UserTableBooking.this, UserMenuActivity.class);
        Reservation reservation;
        switch (view.getId()) {
            case R.id.ban1:
                reservation = new Reservation(1);
                startActivity(intent);
                break;
            case R.id.ban2:
                reservation = new Reservation(2);
                startActivity(intent);
                break;
            case R.id.ban3:
                reservation = new Reservation(3);
                startActivity(intent);
                break;
            case R.id.ban4:
                reservation = new Reservation(4);
                startActivity(intent);
                break;
            case R.id.ban5:
                reservation = new Reservation(5);
                startActivity(intent);
                break;
            case R.id.ban6:
                reservation = new Reservation(6);
                startActivity(intent);
                break;
            case R.id.ban7:
                reservation = new Reservation(7);
                startActivity(intent);
                break;
            case R.id.ban8:
                reservation = new Reservation(8);
                startActivity(intent);
                break;
            case R.id.ban9:
                reservation = new Reservation(9);
                startActivity(intent);
                break;
        }
    }
}