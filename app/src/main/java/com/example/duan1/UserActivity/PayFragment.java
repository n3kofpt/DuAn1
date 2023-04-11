package com.example.duan1.UserActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.duan1.R;

public class PayFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_fragment);
        Spinner spinner = findViewById(R.id.spinner);
        String[] phuongthuc ={"Trả trước 100.000 VNĐ"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(PayFragment.this, android.R.layout.simple_spinner_dropdown_item,phuongthuc);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = adapterView.getItemAtPosition(i).toString();

            }
        });

    }
    public void onclicPay(View view){
        Intent intent = new Intent(PayFragment.this,InformationFragment.class);
        startActivity(intent);
    }
}