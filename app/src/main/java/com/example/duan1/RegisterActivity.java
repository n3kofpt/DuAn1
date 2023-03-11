package com.example.duan1;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    private EditText edtName, edtPhoneNumber, edtUserName, edtPassword;
    private Button btnLogin;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtName = findViewById(R.id.edtRegisterName);
        edtPhoneNumber = findViewById(R.id.edtRegisterPhoneNumber);
        edtUserName = findViewById(R.id.edtRegisterUserName);
        edtPassword = findViewById(R.id.edtRegisterPassword);
        db = FirebaseFirestore.getInstance();
    }

    public void onClickRegister (View view){
        // Lấy giá trị của các EditText
        String name = edtName.getText().toString().trim();
        String phoneNumber = edtPhoneNumber.getText().toString().trim();
        String userName = edtUserName.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();

        // Kiểm tra các trường thông tin có rỗng không
        if (TextUtils.isEmpty(name)) {
            edtName.setError("Please enter your name");
            edtName.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(phoneNumber)) {
            edtPhoneNumber.setError("Please enter your phone number");
            edtPhoneNumber.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(userName)) {
            edtUserName.setError("Please enter your username");
            edtUserName.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            edtPassword.setError("Please enter your password");
            edtPassword.requestFocus();
            return;
        }

        Map<String, Object> user =  new HashMap<>();
        user.put("fbName", name);
        user.put("fbPhoneNumber", phoneNumber);
        user.put("fbUserName", userName);
        user.put("fbPassword", password);
        user.put("fbPermission", false);


        db.collection("Users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                        Toast.makeText(getApplicationContext(), "Đăng Ký Thành Công", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                        Toast.makeText(getApplicationContext(), "Đăng Ký Thất Bại", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}