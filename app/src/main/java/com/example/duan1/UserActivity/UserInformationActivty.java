package com.example.duan1.UserActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.duan1.R;

import java.util.Date;

public class UserInformationActivty extends AppCompatActivity {
        EditText etUserName, etPhoneNumber, etAddress;
        Button btnNext;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_user_information_activty);

            etUserName = findViewById(R.id.etUserName);
            etPhoneNumber = findViewById(R.id.etPhoneNumber);
            etAddress = findViewById(R.id.etAddress);
            btnNext = findViewById(R.id.btnNext);

            TimePicker timePicker = findViewById(R.id.timePicker);
            int hour = timePicker.getCurrentHour(); // Lấy giá trị giờ
            int minute = timePicker.getCurrentMinute(); // Lấy giá trị phút

            DatePicker datePicker = findViewById(R.id.datePicker);
            int day = datePicker.getDayOfMonth();
            int month = datePicker.getMonth();
            int year = datePicker.getYear();

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

                    Intent intent = new Intent(UserInformationActivty.this, PaymentActivity.class);
                    startActivity(intent);
                }
            });
        }
}
