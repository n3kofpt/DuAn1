package com.example.duan1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duan1.AdminActivity.AdminMainActivity;
import com.example.duan1.UserActivity.UserMainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class LoginActivity extends AppCompatActivity {
    private EditText edtUserName, edtPassword;
    private Button btnLogin;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        db = FirebaseFirestore.getInstance();
    }

    public void onClickLoginToRegister(View view){
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    public void onClickLogin(View view) {
        String username = edtUserName.getText().toString();
        String password = edtPassword.getText().toString();

        Log.d(">>>>>LoginActivity", "Username: " + username);
        Log.d(">>>>>LoginActivity", "Password: " + password);

        db.collection("Users").whereEqualTo("fbUserName", username)
                .whereEqualTo("fbPassword", password)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            if (task.getResult().isEmpty()) {
                                // Nếu không có tài liệu nào được trả về, hiển thị thông báo đăng nhập thất bại
                                Log.d(">>>>>LoginActivity", "No user found");
                                Toast.makeText(getApplicationContext(), "Username or password incorrect", Toast.LENGTH_SHORT).show();
                            } else {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Log.d(">>>>>LoginActivity", "User found: " + document.getData());
                                    boolean fbPermission = document.getBoolean("fbPermission");
                                    if (fbPermission) {
                                        Toast.makeText(getApplicationContext(), "You are logged in as an administrator", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(LoginActivity.this, AdminMainActivity.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(LoginActivity.this, UserMainActivity.class);
                                        startActivity(intent);
                                    }
                                }
                            }
                        } else {
                            Log.d(">>>>>LoginActivity", "Error getting users: " + task.getException());
                            Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}