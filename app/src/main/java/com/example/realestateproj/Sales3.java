package com.example.realestateproj;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Sales3 extends AppCompatActivity {
    private RecyclerView recyclerView;
    myadapter adapter;
    DatabaseReference mbase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales3);
        mbase = FirebaseDatabase.getInstance().getReference("Properties").child("Sales");

        recyclerView = findViewById(R.id.recycler1);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<model> options
                = new FirebaseRecyclerOptions.Builder<model>()
                .setQuery(mbase, model.class)
                .build();

        adapter = new myadapter(options);

        recyclerView.setAdapter(adapter);
    }

    @Override protected void onStart()
    {
        super.onStart();
        adapter.startListening();
    }


    @Override protected void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }
}

