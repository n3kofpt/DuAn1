package com.example.duan1.UserActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.duan1.R;

public class UserBookATable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_book_atable);

    }
    public void onlickBook(View view){
        Intent intent = new Intent(UserBookATable.this,MenuFragment.class);
        startActivity(intent);
    }
}