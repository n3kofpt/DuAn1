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
        Intent truyendulieu = new Intent(this, PaymentActivity.class);
        Bundle bundle = new Bundle();
        switch (view.getId()) {
            case R.id.ban1:
                bundle.putInt("tablePosition", 1);
                startActivity(intent);
                break;
            case R.id.ban2:
                bundle.putInt("tablePosition", 2);
                startActivity(intent);
                break;
            case R.id.ban3:
                bundle.putInt("tablePosition", 3);
                startActivity(intent);
                break;
            case R.id.ban4:
                bundle.putInt("tablePosition", 4);
                startActivity(intent);
                break;
            case R.id.ban5:
                bundle.putInt("tablePosition", 5);
                startActivity(intent);
                break;
            case R.id.ban6:
                bundle.putInt("tablePosition", 6);
                startActivity(intent);
                break;
            case R.id.ban7:
                bundle.putInt("tablePosition", 7);
                startActivity(intent);
                break;
            case R.id.ban8:
                bundle.putInt("tablePosition", 8);
                startActivity(intent);
                break;
            case R.id.ban9:
                bundle.putInt("tablePosition", 9);
                startActivity(intent);
                break;
        }
    }
}