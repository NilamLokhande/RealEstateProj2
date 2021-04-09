package com.example.realestateproj;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Det extends AppCompatActivity {
    ImageView img1; TextView nametext; TextView descriptiontext; TextView addressText;TextView prizeText;TextView countryCodeText;TextView ownerNameText; TextView ownerEmailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_det);
        img1= (ImageView) findViewById(R.id.img1);
        nametext=findViewById(R.id.nametext);
        descriptiontext=findViewById(R.id.descriptiontext);
        addressText=findViewById(R.id.addressText);
        prizeText=findViewById(R.id.prizeText);
        countryCodeText=findViewById(R.id.countryCodeText);
        ownerNameText=findViewById(R.id.propertyOwnerText);
        ownerEmailText=findViewById(R.id.propertyOwnerMailText);
        String name = getIntent().getStringExtra("Name");
        String desc = getIntent().getStringExtra("Desc");
        String address= getIntent().getStringExtra("Address");

        String prize= getIntent().getStringExtra("Prize");
        String countryCode= getIntent().getStringExtra("CountryCode");
        String owner= getIntent().getStringExtra("PropOwner");
        String ownerMail= getIntent().getStringExtra("PropMail");
//        byte[] bytes = getIntent().getByteArrayExtra("image");
        String url = getIntent().getStringExtra("url");
//        Toast.makeText(this, url, Toast.LENGTH_SHORT).show();
        nametext.setText(name);
        descriptiontext.setText(desc);
        addressText.setText(address);
        prizeText.setText(prize);
        countryCodeText.setText(countryCode);
        ownerNameText.setText(owner);
        ownerEmailText.setText(ownerMail);

        Glide.with(this).load(url).into(img1);





    }
}