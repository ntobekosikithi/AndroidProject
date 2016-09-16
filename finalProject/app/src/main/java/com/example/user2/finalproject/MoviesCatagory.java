package com.example.user2.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MoviesCatagory extends AppCompatActivity {
    ImageView img1, img2,img3,img4;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_catagory);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3=(ImageView) findViewById(R.id.img3);
        img4=(ImageView) findViewById(R.id.img4);

        int[] image_array = new int[] { R.drawable.toprated, R.drawable.latest,R.drawable.theathre,R.drawable.kidsmovies};

        Picasso.with(this)
                .load(image_array[0])
                .fit()
                .into(img1);

        Picasso.with(this)
                .load(image_array[1])
                .fit()
                .into(img2);

        Picasso.with(this)
                .load(image_array[2])
                .fit()
                .into(img3);

        Picasso.with(this)
                .load(image_array[3])
                .fit()
                .into(img4);

        final ImageView toprated=(ImageView) findViewById(R.id.img1);
        toprated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MoviesCatagory.this, toprated.class );
                startActivity(intent);
            }
        });

        final ImageView best=(ImageView) findViewById(R.id.img2);
        best.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MoviesCatagory.this, best.class );
                startActivity(intent);
            }
        });

        final ImageView theathre=(ImageView) findViewById(R.id.img3);
        theathre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MoviesCatagory.this,theathre.class);
                startActivity(intent);
            }
        });

        final ImageView kids=(ImageView) findViewById(R.id.img4);
        kids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MoviesCatagory.this,kidsmovies.class);
                startActivity(intent);
            }
        });
    }

}
