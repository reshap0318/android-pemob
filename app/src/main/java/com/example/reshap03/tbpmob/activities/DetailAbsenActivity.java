package com.example.reshap03.tbpmob.activities;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.reshap03.tbpmob.R;
import com.example.reshap03.tbpmob.server.appController;
import com.example.reshap03.tbpmob.server.serverapi;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DetailAbsenActivity extends AppCompatActivity {

    TextView dnama, djadwal, dwaktu, dketerangan, did;
    ImageView imgfav;
    int fave,id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_absen);

        //hide action bar
        getSupportActionBar().hide();

        //ambil data
        id = getIntent().getExtras().getInt("id");
        String nama = getIntent().getExtras().getString("nama");
        String menit = getIntent().getExtras().getString("menit");
        String jadwal = getIntent().getExtras().getString("jadwal");
        String tahun = getIntent().getExtras().getString("tahun");
        String bulan = getIntent().getExtras().getString("bulan");
        String tanggal = getIntent().getExtras().getString("tanggal");
        String keterangan = getIntent().getExtras().getString("keterangan");
        String img_url = getIntent().getExtras().getString("img_url");
        fave = getIntent().getExtras().getInt("favo");

        final CollapsingToolbarLayout collaps = findViewById(R.id.collapsingtoolbar_detail);
        dnama = (TextView) findViewById(R.id.dnama);
        dwaktu = (TextView) findViewById(R.id.dwaktu);
        djadwal = (TextView) findViewById(R.id.djadwal);
        dketerangan = (TextView) findViewById(R.id.dketerangan);
        did = (TextView) findViewById(R.id.did);
        imgfav = (ImageView) findViewById(R.id.imgfav);
        if(fave == 0){
            imgfav.setImageResource(R.drawable.ic_favorite_favf);
        }else if(fave == 1){
            imgfav.setImageResource(R.drawable.ic_favorite_fav);
        }


        collaps.setTitleEnabled(true);
        collaps.setTitle(nama);
        dnama.setText(nama);
        dwaktu.setText(menit);
        djadwal.setText(jadwal);
        dketerangan.setText(keterangan);
        did.setText(String.valueOf(id));
        Toast.makeText(DetailAbsenActivity.this,String.valueOf(id),Toast.LENGTH_SHORT).show();

        Glide.with(this).asBitmap().load(img_url).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                Drawable drawable = new BitmapDrawable(resource);
                collaps.setBackground(drawable);
            }
        });

        imgfav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gantifoto();
            }
        });

    }

    public void gantifoto(){
        if(imgfav.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.ic_favorite_favf).getConstantState()){
            imgfav.setImageResource(R.drawable.ic_favorite_fav);
            fave = 1;
            fav(id);
//            savePesertaFavoriteData(this.pesertaModel);
        }else{
            fave = 0;
            fav(id);
            imgfav.setImageResource(R.drawable.ic_favorite_favf);
        }
    }

    public void fav(int id){
        StringRequest simpan = new StringRequest(Request.Method.POST, serverapi.update_url+id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(DetailAbsenActivity.this,"Gagal", Toast.LENGTH_SHORT);
                try {
                    JSONObject res = new JSONObject(response);
                    Toast.makeText(DetailAbsenActivity.this,"Berhasil Menginputkan data", Toast.LENGTH_SHORT);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AbsenActivity.this,"Gagal", Toast.LENGTH_SHORT);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("favo", fave);
                return map;
            }
        };

        appController.getInstance().addToRequestQue(simpan);
    }

}
