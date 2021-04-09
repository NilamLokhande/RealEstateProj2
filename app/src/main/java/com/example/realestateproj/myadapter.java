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

public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder> {
    private Context context;

    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model model) {

        final String name = model.getName();
        final String description = model.getPropDesc();
        String url = model.getUrl();
        holder.nametext.setText(model.getName());
        holder.descriptiontext.setText(model.getPropDesc());
        Glide.with(holder.img1.getContext()).load(url).into(holder.img1);
//        try {
//            URL url1 = new URL(model.getPurl());
//            Bitmap image = BitmapFactory.decodeStream(url1.openConnection().getInputStream());
//        } catch(IOException e) {
//            System.out.println(e);
//        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Det.class);
                intent.putExtra("Name",name);
                intent.putExtra("Desc",description);
                intent.putExtra("Url",url);

                context.startActivity(intent);
            }
        });
    }


    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);
        return new myadapter.myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder {

      ImageView img1; TextView nametext; TextView descriptiontext;

      public myviewholder(@NonNull View itemView) {
          super(itemView);
          context = itemView.getContext();
          img1=itemView.findViewById(R.id.img1);
          nametext=itemView.findViewById(R.id.nametext);
          descriptiontext=itemView.findViewById(R.id.descriptiontext);

      }
  }
}


