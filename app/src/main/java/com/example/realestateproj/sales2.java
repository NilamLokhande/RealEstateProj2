package com.example.realestateproj;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class sales2 extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ListView list;
    String PropNames[]={"LUXURIOUS 4 BEDROOMS FLAT AT THANE", "2 BEDROOM APARTMENT NEAR BEACH", "ONE BEDROOM APARTMENT WITH AC","2 BEDROOM APARTMENT AP NALASOPARA"};
    String Descriptions[]={"Sangeetkar N Dutta Marg, Gharkul Society","CTS No. 185 & 201, Azad Nagar Road No. 3, Off. Veera Desai Road, Andheri West, Mumbai, Maharashtra, INDIA.","ceaser road , opp to Filmalaya Studio","JP Road near Bombay Bazar"};
    int imgs[]={R.drawable.house11, R.drawable.home2,R.drawable.third, R.drawable.fourth};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales2);
        drawerLayout=findViewById(R.id.drawer_layout);
        list= findViewById(R.id.list1);
        MyAdapter adapter= new MyAdapter(this,PropNames,imgs,Descriptions);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent intent = new Intent(getApplicationContext(), PropertyDetails.class);
               intent.putExtra("Propnames2 ",PropNames[i]);
               intent.putExtra("Desc2",Descriptions[i]);
               intent.putExtra("image2",imgs[i]);
               startActivity(intent);

            }
        });

    }
    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String myPropNames[];
        String myDescriptions[];
        int[] imgs;
        MyAdapter(Context c, String[] PropNames, int[] imgs, String[] Descriptions ){
            super(c,R.layout.row, R.id.text1, PropNames );
            this.context=c;
            this.imgs=imgs;
            this.myPropNames=PropNames;
            this.myDescriptions=Descriptions;


        }
        @Override
        public String getItem(int i){
            return null;
        }
        @Override
        public long getItemId(int i){
            return 0;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row= layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.house1);
            TextView myTitle= row.findViewById(R.id.text1);
            TextView myDescription = row.findViewById(R.id.text2);
            images.setImageResource(imgs[position]);
            myTitle.setText(PropNames[position]);
            myDescription.setText(Descriptions[position]);
            return row;
        }
    }
    public void ClickMenu(View view){
        nav2.openDrawer(drawerLayout);
    }
    public void ClickLogo(View  view ){
        nav2.closeDrawer(drawerLayout);
    }
    public void ClickHome(View view){
        nav2.redirectActivity(this, home.class);


    }
    public void ClickSales(View view){
        recreate();
    }
    public void ClickRentals(View view){
        nav2.redirectActivity(this, rentals.class);
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
    public void ClickAboutUs(View view){ nav2.redirectActivity(this, aboutUs.class); }
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