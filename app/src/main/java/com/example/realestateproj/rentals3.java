package com.example.realestateproj;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Context;

import java.util.ArrayList;

public class rentals3 extends AppCompatActivity {

    DatabaseReference ref;
    ArrayList<model> list;
    RecyclerView recyclerView;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales3);

        ref = FirebaseDatabase.getInstance().getReference("Properties").child("Rentals");
        recyclerView = findViewById(R.id.rv);
        searchView = findViewById(R.id.searchview);
        if(ref != null){
            ref.addValueEventListener(new ValueEventListener() {
                @NonNull
                @Override
                protected Object clone() throws CloneNotSupportedException {
                    return super.clone();
                }

                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists()){
                        list = new ArrayList<>();
                        for(DataSnapshot ds : snapshot.getChildren()){
                            list.add(ds.getValue(model.class));
                        }
                        myadapter adapterClass = new myadapter(list);
                        recyclerView.setAdapter(adapterClass);

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(rentals3.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        if (searchView != null){
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    search(newText);
                    return true;
                }
            });
        }

    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    private void search(String str) {
        if (!str.equals("")){
            ArrayList<model> myList = new ArrayList<>();
            for (model object : list){
                if(object.getName().toLowerCase().contains(str.toLowerCase())){
                    myList.add(object);
                }
            }
            myadapter adapterClass = new myadapter(myList);
            recyclerView.setAdapter(adapterClass);
        }

    }
}
