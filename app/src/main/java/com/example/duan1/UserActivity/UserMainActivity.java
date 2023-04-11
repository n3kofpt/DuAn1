package com.example.duan1.UserActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.duan1.R;

public class UserMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
    }
    public void onlickMain(View view) {
        Intent intent = new Intent(UserMainActivity.this, UserBookATable.class);
        startActivity(intent);
    }
    public void onlickMain1(View view) {
        Intent intent = new Intent(UserMainActivity.this, lichhen.class);
        startActivity(intent);
    }

}