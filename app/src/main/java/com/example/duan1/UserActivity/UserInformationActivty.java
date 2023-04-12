package com.example.duan1.UserActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.duan1.R;

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

            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = etUserName.getText().toString();
                    String phoneNumber = etPhoneNumber.getText().toString();
                    String address = etAddress.getText().toString();
                    Reservation reservation = new Reservation(name, phoneNumber, address, hour, minute);
                }
            });
        }
}
