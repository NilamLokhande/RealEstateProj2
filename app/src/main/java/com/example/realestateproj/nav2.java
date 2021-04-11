package com.example.realestateproj;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class nav2 extends AppCompatActivity {


    DrawerLayout drawerLayout;
    Button qMapBtn;
    Button qSale;
    Button qRental;
    Button qFavor;
    Button qAddProperty;
    Button qAddRentals;

    Button qSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav2);
        drawerLayout = findViewById(R.id.drawer_layout);
        qMapBtn= findViewById(R.id.ourLocations2);
        qAddRentals = findViewById(R.id.addRentals);
        qAddRentals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(nav2.this, Addrental.class));
            }
        });
        qMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(nav2.this, MapsActivity.class));
            }
        });
        qSale= findViewById(R.id.sales2);
        qSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(nav2.this, Sales3.class));
            }
        });
        qRental= findViewById(R.id.rentals2);
        qRental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(nav2.this, rentals3.class));
            }
        });
        qFavor= findViewById(R.id.favourites2);
        qFavor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(nav2.this, favorites.class));
            }
        });

        qAddProperty=findViewById(R.id.addProperty);
        qAddProperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(nav2.this, addProperty.class));
            }
        });

    }
    public void ClickMenu(View view){
        openDrawer(drawerLayout);

    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);

    }


    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public void ClickHome(View view){
        recreate();
    }
    public void ClickSales(View view){
        redirectActivity(this,Sales3.class );
    }
    public void ClickRentals(View view){
        redirectActivity(this, rentals3.class);
    }
    public void ClickSearch(View view){
        redirectActivity(this, search.class);
    }
    public void ClickOurLocations(View view){
        redirectActivity(this, MapsActivity.class);
    }
    public void ClickFavorites(View view){
        redirectActivity(this,favorites.class);
    }
    public void ClickAboutUs(View view){
        redirectActivity(this,aboutUs.class);
    }
    public void ClickContactUs(View view){
        redirectActivity(this,contactUs.class);
    }
    public void ClickLogOut(View view){
        logout(this);
    }

    public static void logout(Activity activity) {

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to logout?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finishAffinity();
                System.exit(0);

            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }


    public static void redirectActivity(Activity activity, Class aClass) {

        Intent intent=new Intent(activity, aClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);

    }
    @Override
    protected void onPause(){
        super.onPause();
        closeDrawer(drawerLayout);
    }


}