package com.example.realestateproj;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;


public class myadapter extends RecyclerView.Adapter<myadapter.MyViewHolder>{
    Context context;


    ArrayList<model> list;
    public myadapter(ArrayList<model> list){
        this.list = list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        model model = list.get(position);
        final String name = model.getName();
        final String description = model.getPropDesc();
        final String ownName = model.getmPropOwnerName();
        final String ownMail = model.getmPropOwnerMail();
        final String price = model.getPrice();
        final String countryCode = model.getCCode();
        final String address = model.getAddress();
        String url = model.getUrl();
        holder.nametext.setText(model.getName());
        holder.descriptiontext.setText(model.getPropDesc());
        Glide.with(holder.img1.getContext()).load(url).into(holder.img1);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Det.class);
                intent.putExtra("Name",name);
                intent.putExtra("Desc",description);
                intent.putExtra("Url",url);
                intent.putExtra("OwnerName", ownName);
                intent.putExtra("OwnerMail", ownMail);
                intent.putExtra("Price", price);
                intent.putExtra("CountryCode", countryCode);
                intent.putExtra("Address", address);



                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView img1; TextView nametext; TextView descriptiontext;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            img1=itemView.findViewById(R.id.img1);
            nametext=itemView.findViewById(R.id.nametext);
            descriptiontext=itemView.findViewById(R.id.descriptiontext);
        }
    }

}





















//public class myadapter extends RecyclerView.Adapter<myadapter.MyAdapterViewHolder>{
//    private Context context;
//    public ArrayList<model> arrayList;
//    public myadapter(Context c, ArrayList<model> arrayList){
//        this.context = c;
//        this.arrayList = arrayList;
//    }
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @NonNull
//    @Override
//    public MyAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);
//        return new myadapter.MyAdapterViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyAdapterViewHolder holder, int position) {
//        model model = arrayList.get(position);
//        final String name = model.getName();
//        final String description = model.getPropDesc();
//        final String ownName = model.getmPropOwnerName();
//        final String ownMail = model.getmPropOwnerMail();
//        final String price = model.getPrice();
//        final String countryCode = model.getCCode();
//        final String address = model.getAddress();
//        String url = model.getUrl();
//        holder.nametext.setText(model.getName());
//        holder.descriptiontext.setText(model.getPropDesc());
//        Glide.with(holder.img1.getContext()).load(url).into(holder.img1);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, Det.class);
//                intent.putExtra("Name",name);
//                intent.putExtra("Desc",description);
//                intent.putExtra("Url",url);
//                intent.putExtra("OwnerName", ownName);
//                intent.putExtra("OwnerMail", ownMail);
//                intent.putExtra("Price", price);
//                intent.putExtra("CountryCode", countryCode);
//                intent.putExtra("Address", address);
//
//
//
//                context.startActivity(intent);
//            }
//        });
//    }
//
//
//    public class MyAdapterViewHolder extends RecyclerView.ViewHolder{
//        ImageView img1; TextView nametext; TextView descriptiontext;
//        public MyAdapterViewHolder(@NonNull View itemView) {
//            super(itemView);
////            context = itemView.getContext();
//          img1=itemView.findViewById(R.id.img1);
//          nametext=itemView.findViewById(R.id.nametext);
//          descriptiontext=itemView.findViewById(R.id.descriptiontext);
//        }
//    }
//}


