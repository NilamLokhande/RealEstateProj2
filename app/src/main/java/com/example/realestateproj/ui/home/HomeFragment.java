package com.example.realestateproj.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.realestateproj.MapsActivity;
import com.example.realestateproj.R;
import com.example.realestateproj.Sales3;
import com.example.realestateproj.contactUs;
import com.example.realestateproj.favorites;
import com.example.realestateproj.rentals3;
import com.example.realestateproj.search;

public class HomeFragment extends Fragment {
    private HomeViewModel homeViewModel;

    Button mMapBtn;
    Button mSale;
    Button mRental;
    Button mFavor;
    Button mContactUs;
    Button mSearch;
    public HomeFragment(){

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        mMapBtn = root.findViewById(R.id.ourLocations2);
        mMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MapsActivity.class));
            }
        });
        mSale = root.findViewById(R.id.sales2);
        mSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Sales3.class));
            }
        });
        mRental = root.findViewById(R.id.rentals2);
        mRental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), rentals3.class));
            }
        });
        mFavor = root.findViewById(R.id.favourites2);
        mFavor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), favorites.class));
            }
        });
        mContactUs = root.findViewById(R.id.contact2);
        mContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), contactUs.class));
            }
        });
        mSearch = root.findViewById(R.id.search2);
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), search.class));
            }
        });




        return root;
    }
}