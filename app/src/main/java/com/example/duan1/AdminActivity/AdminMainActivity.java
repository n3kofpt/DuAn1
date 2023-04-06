package com.example.duan1.AdminActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.duan1.R;

public class AdminMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
    }

    public void onClickAdminMenu(View view){
        Intent intent = new Intent(AdminMainActivity.this, AdminMenuActivity.class);
        startActivity(intent);
    }

    public void onClickAdminDeskManagementActivity(View view){
        Intent intent = new Intent(AdminMainActivity.this, AdminDeskManagementActivity.class);
        startActivity(intent);
    }
}