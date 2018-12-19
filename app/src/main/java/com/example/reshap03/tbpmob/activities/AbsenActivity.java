package com.example.reshap03.tbpmob.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.reshap03.tbpmob.R;
import com.example.reshap03.tbpmob.server.appController;
import com.example.reshap03.tbpmob.server.serverapi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public class AbsenActivity extends AppCompatActivity {

   EditText nama, keterangan;
   Button fbupload, fbsimpan;
   ImageView fview;
    Bitmap bitmap;
    private static final String TAG = AbsenActivity.class.getSimpleName();
    private static final int CAMERA_REQUEST_CODE = 7777;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absen);

        nama = (EditText) findViewById(R.id.fnama);
        keterangan = (EditText) findViewById(R.id.fketerangan);
        fbupload = (Button) findViewById(R.id.fupload);
        fbsimpan = (Button) findViewById(R.id.fsubmit);
        fview = (ImageView) findViewById(R.id.imageView);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fbsimpan.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                simpandata();
                Intent intent = new Intent(AbsenActivity.this, ListAbsenActivity.class);
                startActivity(intent);
            }
        });

        fbupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_REQUEST_CODE);
            }
        });

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case(CAMERA_REQUEST_CODE) :
                if(resultCode == Activity.RESULT_OK)
                {
                    // result code sama, save gambar ke bitmap

                    bitmap = (Bitmap) data.getExtras().get("data");
                    fview.setImageBitmap(bitmap);
                }
                break;
        }
    }

    private void simpandata(){
        StringRequest simpan = new StringRequest(Request.Method.POST, serverapi.create_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(AbsenActivity.this,"Gagal", Toast.LENGTH_SHORT);
                try {
                    JSONObject res = new JSONObject(response);
                    Toast.makeText(AbsenActivity.this,"Berhasil Menginputkan data", Toast.LENGTH_SHORT);
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
                String convert = ImageString(bitmap);
                map.put("nama", nama.getText().toString());
                map.put("foto", convert);
                map.put("keterangan", keterangan.getText().toString());
                return map;
            }
        };

        appController.getInstance().addToRequestQue(simpan);
    }

    private String ImageString (Bitmap bitmap){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
        byte[] imgbyte  = outputStream.toByteArray();

        String encode = Base64.encodeToString(imgbyte, Base64.DEFAULT);

        return encode;
    }
}
