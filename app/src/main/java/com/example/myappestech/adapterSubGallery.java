package com.example.myappestech;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapterSubGallery extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final ArrayList<myGallery> images;
    private final Context context;
    private CustomItemClick listener;

    public adapterSubGallery(ArrayList<myGallery> images, Context context, CustomItemClick listener) {
        this.images = images;
        this.context = context;
        this.listener = listener;
    }

    static class MyHolder extends RecyclerView.ViewHolder {

        public final ImageView imageView;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageRv);
        }
    }
    @NonNull
    @Override

    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recyclerviewgallery, parent, false);
        MyHolder myHolder = new MyHolder(v);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        myGallery image = images.get(position);
        int resource = image.getImage();

        MyHolder myHolder = (MyHolder) holder;
        myHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(position);
            }
        });

        myHolder.imageView.setImageResource(resource);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }
}

