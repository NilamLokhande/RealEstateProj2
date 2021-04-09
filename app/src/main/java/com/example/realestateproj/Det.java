package com.example.realestateproj;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Det extends AppCompatActivity {
    ImageView img1; TextView nametext; TextView descriptiontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_det);
        img1= (ImageView) findViewById(R.id.img1);
        nametext=findViewById(R.id.nametext);
        descriptiontext=findViewById(R.id.descriptiontext);
        String name = getIntent().getStringExtra("Name");
        String desc = getIntent().getStringExtra("Desc");
//        byte[] bytes = getIntent().getByteArrayExtra("image");
        String url = getIntent().getStringExtra("url");
//        Toast.makeText(this, url, Toast.LENGTH_SHORT).show();
        nametext.setText(name);
        descriptiontext.setText(desc);
        Glide.with(this).load(url).into(img1);





    }
}