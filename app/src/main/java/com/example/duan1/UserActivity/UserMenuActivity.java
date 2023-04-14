package com.example.duan1.UserActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.duan1.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class UserMenuActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MenuAdapter menuAdapter;
    private Button nextToUserInformatonActivity, btnGioHang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_menu);

        btnGioHang = findViewById(R.id.btnGioHang);
        nextToUserInformatonActivity = findViewById(R.id.NextToUserInformatonActivity);
        recyclerView = findViewById(R.id.user_menu_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        menuAdapter = new MenuAdapter(new ArrayList<>());
        recyclerView.setAdapter(menuAdapter);

        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        CollectionReference menuCollectionRef = firestore.collection("Menu");

        menuCollectionRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                List<Menu> menuItemList = new ArrayList<>();
                for (DocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                    Menu menu = documentSnapshot.toObject(Menu.class);
                    menuItemList.add(menu);
                }
                menuAdapter.setData(menuItemList);
            }
        });

        btnGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserMenuActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        nextToUserInformatonActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserMenuActivity.this, UserInformationActivty.class);
                startActivity(intent);
            }
        });
    }
}