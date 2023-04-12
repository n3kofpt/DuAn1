package com.example.duan1.AdminActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.R;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {
    private List<Menu> menuList;
    String[] options = new String[]{"Sửa", "Xóa"};

    public interface ItemClickListener {
        void onClick(View view, int position,boolean isLongClick);
    }

    public MenuAdapter(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public void setData(List<Menu> menuList) {
        this.menuList = menuList;
        notifyDataSetChanged();
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // lấy layout của menu item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_item, parent, false);
        return new MenuViewHolder(view); // Trả về menu item view
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        // gọi bên viewholder (lấy thành phần ánh xạ bên item) vào cái này để xử lý
        Menu menu = menuList.get(position);
        holder.imageView.setImageResource(menu.getImageResourceId());
        holder.foodNameTextView.setText(menu.getFoodName());
        holder.priceTextView.setText(menu.getPrice());

        String foodName = menuList.get(position).getFoodName();
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(isLongClick){
                    // xử lý long click
//                    Log.d(">>>>>>>>>>>>>>>>", "onLongClick: " + menuList.get(position));
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setItems(options, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case 0:
                                    // Xử lý khi người dùng chọn "Sửa"
                                    Log.d(">>>>>>>", "onClick: Sửa");

                                    // Hiển thị dialog sửa món ăn
                                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                                    builder.setTitle("Sửa thông tin món ăn");

                                    // Sử dụng layout dialog_add_menu.xml để hiển thị dialog
                                    View viewD = LayoutInflater.from(view.getContext()).inflate(R.layout.dialog_add_menu, null);
                                    builder.setView(viewD);

                                    // Lấy ra các view trong layout để set giá trị món ăn hiện tại
                                    EditText foodNameEditText = viewD.findViewById(R.id.dialog_food_name);
                                    EditText priceEditText = viewD.findViewById(R.id.dialog_price);
                                    ImageView imageView = viewD.findViewById(R.id.dialog_image);

                                    // Set giá trị cũ cho các view
                                    foodNameEditText.setText(menuList.get(position).getFoodName());
                                    priceEditText.setText(menuList.get(position).getPrice());

                                    // Xử lý sự kiện khi người dùng ấn nút "Sửa"
                                    builder.setPositiveButton("Sửa", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            // Lấy giá trị mới của món ăn sau khi sửa
                                            String newFoodName = foodNameEditText.getText().toString();
                                            String newPrice = priceEditText.getText().toString();

                                            // Tìm kiếm document cần sửa bằng biến foodName
                                            FirebaseFirestore firestore = FirebaseFirestore.getInstance();
                                            CollectionReference menuCollectionRef = firestore.collection("Menu");
                                            menuCollectionRef.whereEqualTo("foodName", foodName)
                                                    .get()
                                                    .addOnSuccessListener(queryDocumentSnapshots -> {
                                                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                                                            // Cập nhật các trường dữ liệu của document
                                                            documentSnapshot.getReference().update("foodName", newFoodName);
                                                            documentSnapshot.getReference().update("price", newPrice);
                                                            // Hiển thị thông báo sửa thành công
                                                            Toast.makeText(view.getContext(), "Sửa món thành công", Toast.LENGTH_SHORT).show();
                                                        }
                                                    })
                                                    .addOnFailureListener(e -> {
                                                        Log.d("MenuAdapter", "Lỗi khi sửa món: ", e);
                                                        Toast.makeText(view.getContext(), "Lỗi khi sửa món", Toast.LENGTH_SHORT).show();
                                                    });
                                        }
                                    });

                                    // Xử lý sự kiện khi người dùng ấn nút "Hủy"
                                    builder.setNegativeButton("Hủy", null);
                                    builder.create().show();
                                    break;
                                case 1:
                                    Log.d(">>>>>>>", "onClick: Xóa");
                                    // Xử lý khi người dùng chọn "Xóa"
                                    Log.d(">>>>>>>>>>>>>", foodName);
                                    menuList.remove(position);
                                    notifyItemRemoved(position);
                                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                                    db.collection("Menu")
                                            .whereEqualTo("foodName", foodName)
                                            .get()
                                            .addOnSuccessListener(queryDocumentSnapshots -> {
                                                for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                                                    document.getReference().delete();
                                                }
                                                Toast.makeText(view.getContext(), "Xóa món thành công", Toast.LENGTH_SHORT).show();
                                            })
                                            .addOnFailureListener(e -> {
                                                Log.d("MenuAdapter", "Lỗi khi xóa món: ", e);
                                                Toast.makeText(view.getContext(), "Lỗi khi xóa món", Toast.LENGTH_SHORT).show();
                                            });
                                    break;
                            }
                        }
                    });
                    builder.show();
                }
                else {
                    // xử lý 1 click
                    Log.d(">>>>>>>>>>>>>>>>", "onClick: " + menuList.get(position));
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }
}

