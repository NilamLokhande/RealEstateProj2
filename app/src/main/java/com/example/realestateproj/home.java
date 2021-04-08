package com.example.realestateproj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class home extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Button pMapBtn;
    Button pSale;
    Button pRental;
    Button pFavor;
    Button pContactUs;
    Button pSearch;
    Button pAddProperty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawerLayout= findViewById(R.id.drawer_layout);
        pMapBtn= findViewById(R.id.ourLocations2);
        pMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, MapsActivity.class));
            }
        });
        pSale= findViewById(R.id.sales2);
        pSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, Sales3.class));
            }
        });
        pRental= findViewById(R.id.rentals2);
        pRental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, rentals3.class));
            }
        });
        pFavor= findViewById(R.id.favourites2);
        pFavor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, favorites.class));
            }
        });
        pSearch= findViewById(R.id.search2);
        pSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, search.class));
            }
        });
        pAddProperty=findViewById(R.id.addProperty);
        pAddProperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, addProperty.class));
            }
        });


    }
    public void ClickMenu(View view){
        nav2.openDrawer(drawerLayout);
    }
    public void ClickLogo(View  view ){
        nav2.closeDrawer(drawerLayout);
    }
    public void ClickHome(View view){
        recreate();

    }
    public void ClickSales(View view){
        nav2.redirectActivity(this, Sales3.class);
    }
    public void ClickRentals(View view){
        nav2.redirectActivity(this, rentals3.class);
    }
    public void ClickSearch(View view){
        nav2.redirectActivity(this, search.class);
    }
    public void ClickOurLocations(View view){
        nav2.redirectActivity(this, MapsActivity.class);
    }
    public void ClickFavorites(View view){
        nav2.redirectActivity(this, favorites.class);
    }
    public void ClickAboutUs(View view){
        nav2.redirectActivity(this, aboutUs.class);
    }
    public void ClickContactUs(View view){
        nav2.redirectActivity(this, contactUs.class);
    }
    public void ClickLogOut(View view){
        nav2.logout(this);
    }
    @Override
    protected void onPause(){
        super.onPause();
        nav2.closeDrawer(drawerLayout);
    }

}