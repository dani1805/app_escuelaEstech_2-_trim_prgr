package com.example.myappestech;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapterBlog extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List <myBlog> myBlogList;
    private final CustomItemClick listener;

    public adapterBlog(Context context, List<myBlog> myBlogList, CustomItemClick listener) {
        this.context = context;
        this.myBlogList = myBlogList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View pView = inflater.inflate(R.layout.blogholder, parent, false);
        return new BlogHolder(pView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BlogHolder mHolder = (BlogHolder) holder;
        final myBlog item = myBlogList.get(position);
        int date = item.getDate();
        int image = item.getImage();
        int title = item.getTitle();

        mHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(position);
            }
        });
        mHolder.setData(title, date, image);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return myBlogList.size();
    }

    class BlogHolder extends RecyclerView.ViewHolder {
        private final TextView date;
        private final TextView title;
        private final ImageView image;

        BlogHolder(View view) {
            super(view);
            date = view.findViewById(R.id.tvDate);
            title = view.findViewById(R.id.tvTitle);
            image = view.findViewById(R.id.imageBlog);

        }

        void setData(int title, int date, int image) {
            this.date.setText(date);
            this.title.setText(title);
            Drawable drawable = context.getResources().getDrawable(image);
            this.image.setImageDrawable(drawable);
        }
    }
}
