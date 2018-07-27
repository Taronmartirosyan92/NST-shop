package com.example.armen.mynoutbook.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.armen.mynoutbook.R;
import com.example.armen.mynoutbook.adapters.InfoImageAdapter;
import com.example.armen.mynoutbook.models.ProductModel;
import com.example.armen.mynoutbook.providers.PrProvider;
import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity {
    ProductModel productModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        productModel = PrProvider.getIntPosition();
        final LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        final TextView textView = findViewById(R.id.info_text);
        final RatingBar rab = findViewById(R.id.info_rb);
        final TextView rabInt = findViewById(R.id.info_rb_int);
        InfoImageAdapter adapter = new InfoImageAdapter(InfoActivity.this, productModel.getImageUrl());
        RecyclerView recyclerView = findViewById(R.id.info_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        ImageView imageView = findViewById(R.id.image_title);
        Picasso.get()
                .load(productModel.getImageUrl()[0])
                .placeholder(R.drawable.ic_image_aspect_24dp)
                .into(imageView);
        rab.setRating(productModel.getRating());
        rabInt.setText(String.valueOf(productModel.getRating()));
        textView.setText(productModel.getDescription());
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitle(productModel.getTitle());
        initializationVideoView();
    }

    private void initializationVideoView() {
        final VideoView videoView = findViewById(R.id.infoVideo);
        videoView.setVideoURI(Uri.parse(productModel.getVideoUrl()));
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.start();
    }
}
