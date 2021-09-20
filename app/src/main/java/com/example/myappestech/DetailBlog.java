package com.example.myappestech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailBlog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_blog);

        Button back = findViewById(R.id.back);
        ImageView header = findViewById(R.id.header);
        ImageView image2 = findViewById(R.id.image2);
        TextView titleHeader = findViewById(R.id.titleHeader);
        TextView date = findViewById(R.id.date);
        TextView description = findViewById(R.id.description);
        TextView description3 = findViewById(R.id.description3);
        TextView description4 = findViewById(R.id.description4);
        ImageView imageview5 = findViewById(R.id.imageView5);


        Bundle bundle = getIntent().getExtras();
        myBlog item = bundle.getParcelable("item");

        titleHeader.setText(item.getTitle());
        Drawable drawable = getResources().getDrawable(item.getImage());
        header.setImageDrawable(drawable);
        date.setText(item.getDate());
        description.setText(item.getFirstText());
        Drawable otherDrawable = getResources().getDrawable(item.getFirstImage());
        image2.setImageDrawable(otherDrawable);
        description3.setText(item.getSecondText());
        Drawable secondDrawable = getResources().getDrawable(item.getSecondImage());
        imageview5.setImageDrawable(secondDrawable);
        description4.setText(item.getThirdText());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });












    }
}