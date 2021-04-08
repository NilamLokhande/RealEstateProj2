package com.example.realestateproj;

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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class sales2 extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ListView list;
    String PropNames[]={"LUXURIOUS 4 BEDROOMS FLAT AT THANE", "2 BEDROOM APARTMENT NEAR BEACH", "ONE BEDROOM APARTMENT WITH AC","2 BEDROOM APARTMENT AP NALASOPARA","2 BHK Flat For Sale In Parkwoods In Thane West","2 BHK Flat For Sale In Sanskruti In Dadar West","Apartment for Sale In Hari Om Complex In Nalasopara West","3 BHK Flat For Sale In Vasant Athena In Thane West","2 BHK Flat For Sale In Greenfields Chs In Andheri West","1 BHK Flat For Sale In Lokhandwala Woodland","1 BHK Flat For Sale In Amit Chs In Ville Parle East","3 BHK Flat For Sale In Silicon Park In Malad West","2 BHK Flat For Sale In Bhaskar Nivas In Andheri West","2 BHK Flat For Sale In Bachraj Paradise In Virar West","3 BHK For Sale In Zanira Tattva Life Rowhouse In Karjat"};
    String Descriptions[]={"Sangeetkar N Dutta Marg, Gharkul Society","CTS No. 185 & 201, Azad Nagar Road No. 3, Off. Veera Desai Road, Andheri West, Mumbai, Maharashtra, INDIA.","ceaser road , opp to Filmalaya Studio","JP Road near Bombay Bazar","Ghodbunder Road,Near DMART,Thane West","SHIVAJI PARK Near Shiv Sena Bhavan","Station Rd near Narayana eTechno School , Nalasopara","Near Viviana Mall,On Eastern Express Highway, Service Rd, Near Viviana Mall","Greenfields CHS, Lokhandwala Complex, Andheri West, Mumbai, Maharashtra 400053","Ashok academic school","next to Jal Usha , Netaji Subhash Nagar","Silicon Park, Jankalyan Nagar, Malad West, Mumbai, Maharashtra","Gulmohar Garden, Yari Road, Yagna Nagar, Versova, Andheri West, Mumbai, Maharashtra","Avenue A -3 , Global City","near Sidhtek Ganpati"};
    int imgs[]={R.drawable.house11, R.drawable.home2,R.drawable.third, R.drawable.fourth, R.drawable.fifth, R.drawable.sixth, R.drawable.seventh, R.drawable.eight, R.drawable.ninth, R.drawable.tenth,R.drawable.eleventh,R.drawable.twelfth,R.drawable.thirteen, R.drawable.fourteen, R.drawable.fifteen};


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