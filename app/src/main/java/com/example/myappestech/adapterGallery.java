package com.example.myappestech;

import android.content.Context;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapterGallery extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final ArrayList<myGallery>images;
    private final Context context;
    public MyHolder myHolder;
    private int indexResource; // primera foto de nuestro ArrayList;

    public adapterGallery(ArrayList<myGallery> images, Context context) {
        this.images = images;
        this.context = context;
        indexResource = images.get(0).getImage(); // En el constructor guardamos nuestra primera imagen
    }

    static class MyHolder extends RecyclerView.ViewHolder {

        public final ImageView imageView;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.myImage);
        }
    }
    @NonNull
    @Override

    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.viewpagercell, parent, false);
        myHolder = new MyHolder(v);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        myGallery image = images.get(position);
        int resource = image.getImage();

        myHolder = (MyHolder) holder;
        myHolder.imageView.setImageResource(resource);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public void setResource(int position) {

        // Preguntamos si posicion es igual a 0, ponemos la primera imagen guardada en el constructor, y si no, se van estableciendo de forma dinámica
        if (position == 0) {
            images.get(0).setImage(indexResource);
        } else {
            myGallery item = images.get(position);
            images.get(0).setImage(item.getImage());
        }
        this.notifyDataSetChanged();
    }
}
