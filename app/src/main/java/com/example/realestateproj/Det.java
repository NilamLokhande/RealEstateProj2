package com.example.realestateproj;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.baidu.mapapi.map.SupportMapFragment;
import com.bumptech.glide.Glide;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Det extends AppCompatActivity implements OnMapReadyCallback {
    ImageView img1; TextView nametext; TextView descripto; TextView addressText;TextView prizeText;TextView countryCodeText;TextView ownerNameText; TextView ownerEmailText;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_det);
//        img1= (ImageView) findViewById(R.id.img1);
        nametext=findViewById(R.id.nametext);
        descripto=findViewById(R.id.descriptiontext);
        addressText=findViewById(R.id.addressText);
        prizeText=findViewById(R.id.prizeText);
        countryCodeText=findViewById(R.id.countryCodeText);
        ownerNameText=findViewById(R.id.propertyOwnerText);
        ownerEmailText=findViewById(R.id.propertyOwnerMailText);


        name = getIntent().getStringExtra("Name");
        String desc = getIntent().getStringExtra("Desc");
        String address= getIntent().getStringExtra("Address");

        String prize= getIntent().getStringExtra("Price");
        String countryCode= getIntent().getStringExtra("CountryCode");
        String owner= getIntent().getStringExtra("OwnerName");
        String ownerMail= getIntent().getStringExtra("OwnerMail");
//        byte[] bytes = getIntent().getByteArrayExtra("image");
//        String url = getIntent().getStringExtra("url");
//        Toast.makeText(this, url, Toast.LENGTH_SHORT).show();
        nametext.setText(name);
        descripto.setText(desc);
        addressText.setText(address);
        prizeText.setText(prize);
        countryCodeText.setText(countryCode);
        ownerNameText.setText(owner);
        ownerEmailText.setText(ownerMail);

//        Glide.with(this).load(url).into(img1);





    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.addMarker(new MarkerOptions()
        .position(new LatLng(0,0))
        .title(name));
    }
}