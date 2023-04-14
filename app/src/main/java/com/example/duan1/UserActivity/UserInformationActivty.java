package com.example.duan1.UserActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.duan1.R;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class UserInformationActivty extends AppCompatActivity {
        EditText etUserName, etPhoneNumber, etAddress;
        Button btnNext,timePicker,datePicker;
        int hour,minute,day,month,year;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_user_information_activty);

            etUserName = findViewById(R.id.etUserName);
            etPhoneNumber = findViewById(R.id.etPhoneNumber);
            etAddress = findViewById(R.id.etAddress);
            btnNext = findViewById(R.id.btnNext);
            timePicker = findViewById(R.id.timePicker);
            datePicker = findViewById(R.id.datePicker);

            Bundle bundle = new Bundle();
            Intent truyendulieu = new Intent(this, PaymentActivity.class);

            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = etUserName.getText().toString();
                    String phoneNumber = etPhoneNumber.getText().toString();
                    String address = etAddress.getText().toString();

                    // truyền dữ liệu
                    bundle.putString("name", name);
                    bundle.putString("phoneNumber", phoneNumber);
                    bundle.putString("address", address);
                    bundle.putInt("hour", hour);
                    bundle.putInt("minute", minute);
                    bundle.putInt("day", day);
                    bundle.putInt("month", month);
                    bundle.putInt("year", year);
                    truyendulieu.putExtras(bundle);
                    Log.d(">>>>>>>>>>>>>>", "onClick: " + hour + minute + day + month + year);
                    Intent intent = new Intent(UserInformationActivty.this, PaymentActivity.class);
                    startActivity(intent);
                }
            });
            timePicker.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TimePickerDialog timePickerDialog = new TimePickerDialog(UserInformationActivty.this,
                            new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker timePicker, int i, int i1) {
                                     hour = i;
                                    minute = i1;
                                }
                            },0,0,true);
                    timePickerDialog.show();

                }
            });
            datePicker.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DatePickerDialog datePickerDialog = new DatePickerDialog(UserInformationActivty.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        year = i;
                        month = i1;
                        day = i2;
                        }
                    },2023,1,1);
                    datePickerDialog.show();
                }

            });
        }



}
