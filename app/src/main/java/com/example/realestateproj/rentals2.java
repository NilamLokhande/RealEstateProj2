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

public class rentals2 extends AppCompatActivity {
    ListView list2;
    String PropNames[] = {"2 BHK Flat For Rent In Starship Chs No 11", "1 BHK Flat For Rent In Samarth Bhoomi Samarth A Wing", "2 BHK Flat For Rent In Lamarie Chs In Andheri West", "2 BHK Flat For Rent In Malwani Asha Chs In Malad West", "2 BHK Flat For Rent In The Baya Park In Dadar West", "1 BHK Flat For Rent In Ganesh Krupa In Thane West", "2 BHK Flat For Rent In Parkview In Thane West, Thane", "1 BHK Flat For Rent In Royal Palms In Goregaon East", "2 BHK Flat For Rent In Hari Krishna Residency In Kamothe, Panvel", "1 BHK Flat For Rent In Montana Chs Lokhandwala Complex", "2 BHK Flat For Rent In Sai Ashish In Bandra West", "3 BHK Flat For Rent In Khar Rose Minar In Khar West", "2 BHK Flat For Rent In Churchgate", "2 BHK Flat For Rent In Radhey Galaxy In Karjat", "1 BHK Flat For Rent In Casa Bliss In Virar West"};
    String Descriptions[] = {"new Link Rd, Oshiwara, sheree ji hotel", "Near Hub Mall", "Jai Bhavani Mata Rd Near Varsha Sugandha CHS", "Near Malvani Bus Depot", "Near Plaza Cinema, Tulsi Pipe Road, Lower Parel, Dadar, Kasaravadi, Dadar", "B Cabin, Gokhle Rd., Navpada, Near Suryakiran Society and Prakash Medical", "Parkview view thane", "Royal Palms, Aarey Colony, Goregaon East, Mumbai, Maharashtra 400065", "kamothe, Panvel, Navi Mumbai, Maharashtra", "SV Patel Nagar", "Sai Ashish, Tertulian Rd, Mount Mary, Bandra West, Mumbai, Maharashtra 400050, India", "10th Road, Khar West, Mumbai, Maharashtra, INDIA", "10th Road, Khar West, Mumbai, Maharashtra, INDIA", "Standalone Building, IMC Marg ,Near Churchgate Railway Police Station", "Survey No. 43/ 1-43, Off Karjat Chowk Road, Karjat, Mumbai, Maharashtra, INDIA", "Rustomjee Global City, Virar West, Virar, Maharashtra 401303, India"};
    int imgs[] = {R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8, R.drawable.image9, R.drawable.image10, R.drawable.image11, R.drawable.image12, R.drawable.image13, R.drawable.image14, R.drawable.image15, R.drawable.image16, R.drawable.image17, R.drawable.image18, R.drawable.image19};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rentals2);
        list2 = findViewById(R.id.list2);

        MyAdapter2 adapter = new MyAdapter2(this, PropNames, imgs, Descriptions);
        list2.setAdapter(adapter);

        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), rentalDetails.class);
                intent.putExtra("Propnames2 ", PropNames[i]);
                intent.putExtra("Desc2", Descriptions[i]);
                intent.putExtra("image2", imgs[i]);
                startActivity(intent);

            }
        });
    }

    class MyAdapter2 extends ArrayAdapter<String> {
        Context context;
        String myPropNames[];
        String myDescriptions[];
        int[] imges;

        MyAdapter2(Context c, String[] PropNames, int[] imgs, String[] Descriptions) {
            super(c, R.layout.row2, R.id.text1, PropNames);
            this.context = c;
            this.imges = imgs;
            this.myPropNames = PropNames;
            this.myDescriptions = Descriptions;


        }

        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row2, parent, false);
            ImageView images = row.findViewById(R.id.rental1);
            TextView myTitle = row.findViewById(R.id.text1);
            TextView myDescription = row.findViewById(R.id.text2);
            images.setImageResource(imgs[position]);
            myTitle.setText(PropNames[position]);
            myDescription.setText(Descriptions[position]);
            return row;
        }
    }
}




