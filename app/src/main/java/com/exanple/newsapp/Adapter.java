package com.exanple.newsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolderData> {
    Context context;
    ArrayList<ModelClass>modelClassArrayList;

    public Adapter(Context context, ArrayList<ModelClass> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
       return new ViewHolderData(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolderData holder, int position) {
        holder.mtime.setText("Published At :- "+modelClassArrayList.get(position).getPublishedAt());
        holder.mauthor.setText(modelClassArrayList.get(position).getAuthor());
        holder.mcontent.setText(modelClassArrayList.get(position).getDescription());
        holder.mheading.setText(modelClassArrayList.get(position).getTitle());
        Glide.with(context).load(modelClassArrayList.get(position).getUrlToImage()).into(holder.imageView);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,WebbView.class);
                intent.putExtra("url",modelClassArrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public class ViewHolderData extends RecyclerView.ViewHolder {
        TextView mheading,mcontent,mauthor,mtime;
        ImageView imageView ;
        CardView cardView;
        public ViewHolderData(@NonNull View itemView) {
            super(itemView);
            mheading = itemView.findViewById(R.id.mainheading);
            mcontent = itemView.findViewById(R.id.content);
            mauthor = itemView.findViewById(R.id.author);
           mtime = itemView.findViewById(R.id.time);
            imageView= itemView.findViewById(R.id.imageview);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }
}
