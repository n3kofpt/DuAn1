package com.example.duan1.AdminActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.duan1.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class AdminMenuActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MenuAdapter menuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);

        recyclerView = findViewById(R.id.menu_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        menuAdapter = new MenuAdapter(new ArrayList<>());
        recyclerView.setAdapter(menuAdapter);

        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        CollectionReference menuCollectionRef = firestore.collection("Menu");

        menuCollectionRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                List<Menu> menuItemList = new ArrayList<>();
                for (DocumentSnapshot documentSnapshot : queryDocumentSnapshots){
                    Menu menu = documentSnapshot.toObject(Menu.class);
                    menuItemList.add(menu);
                    Log.d(">>>>>>>>>>>>", "onSuccess: " + menu.getFoodName());
                }
                menuAdapter.setData(menuItemList);
            }
        });
    }

    public void showAddMenuDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setTitle("Thêm món ăn");

        view = LayoutInflater.from(this).inflate(R.layout.dialog_add_menu, null);
        builder.setView(view);

        EditText foodNameEditText = view.findViewById(R.id.dialog_food_name);
        EditText priceEditText = view.findViewById(R.id.dialog_price);
        ImageView imageView = view.findViewById(R.id.dialog_image);

        Log.d(">>>>>>>>>", "showAddMenuDialog: Thêm Món Ăn");
        builder.setPositiveButton("Thêm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String foodName = foodNameEditText.getText().toString();
                String price = priceEditText.getText().toString();

                // tạo 1 đối tượng Menu nhằm add lên firestore
                Menu menu = new Menu(R.drawable.ic_baseline_restaurant_menu_24, foodName, price);

                FirebaseFirestore firestore = FirebaseFirestore.getInstance();
                CollectionReference menuCollectionRef = firestore.collection("Menu");
                Log.d(">>>>>>>", "onClick: Thêm Món Ăn");
                menuCollectionRef.add(menu).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("Firestore", "Menu added with ID: " + documentReference.getId());
                    }
                });
            }
        });

        builder.setNegativeButton("Hủy", null);

        builder.create().show();
    }
}