package com.example.reshap03.tbpmob.activities;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.reshap03.tbpmob.R;

public class DetailAbsenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_absen);

        //hide action bar
        getSupportActionBar().hide();

        //ambil data
        String nama = getIntent().getExtras().getString("nama");
        String menit = getIntent().getExtras().getString("menit");
        String jadwal = getIntent().getExtras().getString("jadwal");
        String tahun = getIntent().getExtras().getString("tahun");
        String bulan = getIntent().getExtras().getString("bulan");
        String tanggal = getIntent().getExtras().getString("tanggal");
        String keterangan = getIntent().getExtras().getString("keterangan");
        String img_url = getIntent().getExtras().getString("img_url");

        final CollapsingToolbarLayout collaps = findViewById(R.id.collapsingtoolbar_detail);

        collaps.setTitleEnabled(true);

        Glide.with(this).asBitmap().load(img_url).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                Drawable drawable = new BitmapDrawable(resource);
                collaps.setBackground(drawable);
            }
        });

    }
}
