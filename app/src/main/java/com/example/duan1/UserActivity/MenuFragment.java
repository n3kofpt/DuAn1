package com.example.duan1.UserActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.duan1.R;

public class MenuFragment extends AppCompatActivity {
    private NumberPicker numberPicker;
    private TextView textNumber ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_fragment);

        numberPicker = findViewById(R.id.numberPicker);
        Spinner spinner = findViewById(R.id.spinnermenu);
        String[] thucdon ={"Hải sản","Thịt lợn","Thịt bò"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MenuFragment.this, android.R.layout.simple_spinner_dropdown_item,thucdon);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = adapterView.getItemAtPosition(i).toString();

            }
        });

        numberPicker.setMaxValue(10);
        numberPicker.setMinValue(0);
        numberPicker.setValue(0);
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                textNumber.setText(i1);
            }
        });


    }
}