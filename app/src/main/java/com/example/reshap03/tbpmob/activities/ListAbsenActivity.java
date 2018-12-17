package com.example.reshap03.tbpmob.activities;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.reshap03.tbpmob.R;
import com.example.reshap03.tbpmob.adapter.listadapter;
import com.example.reshap03.tbpmob.model.listabsen;
import com.example.reshap03.tbpmob.server.appController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListAbsenActivity extends AppCompatActivity {

    private final String JSON_URL = "https://murmuring-lowlands-33642.herokuapp.com/api/absen";
    private JsonArrayRequest ArrayRequest ;
    private RequestQueue requestQueue ;
    private List<listabsen> daftarabsen= new ArrayList<>();
    private RecyclerView myrv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_absen);
        myrv = findViewById(R.id.rvlist);
        if(cekjaringan()){
            Toast.makeText(ListAbsenActivity.this, "Jaringan Ada", Toast.LENGTH_SHORT).show();
            jsoncall();
        }else if(!cekjaringan()){
            Toast.makeText(ListAbsenActivity.this, "Jaringan Tidak Ada", Toast.LENGTH_SHORT).show();
        }
    }

    private  boolean cekjaringan(){
        boolean wifi = false;
        boolean data = false;

        ConnectivityManager koneksi = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] informasi = koneksi.getAllNetworkInfo();

        for(NetworkInfo info:informasi)
        {

            if(info.getTypeName().equalsIgnoreCase("WIFI")){
                if(info.isConnected()){
                    wifi = true;
                }
            }

            if(info.getTypeName().equalsIgnoreCase("MOBILE")){
                if(info.isConnected()){
                    data = true;
                }
            }
        }
        return wifi||data;
    }

    private void jsoncall() {
        //Arrayreq dari variable atas
        ArrayRequest = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            public void onResponse(JSONArray response) {

//                Toast.makeText(getApplicationContext(), "berhasil",Toast.LENGTH_SHORT).show();

                JSONObject jsonObject = null;


                for (int i = 0 ; i<response.length();i++) {

//                    Toast.makeText(getApplicationContext(),String.valueOf(i),Toast.LENGTH_SHORT).show();

                    try {

                        jsonObject = response.getJSONObject(i);
                        listabsen lsabsen = new listabsen();
                        //nama di ujung di ambil dari hasil query
                        lsabsen.setNama(jsonObject.getString("nama"));
                        lsabsen.setJadwal(jsonObject.getString("jadwal"));
                        lsabsen.setMenit(jsonObject.getString("times"));
                        lsabsen.setTanggal(jsonObject.getString("tanggal"));
                        lsabsen.setBulan(jsonObject.getString("bulan"));
                        lsabsen.setTahun(jsonObject.getString("tahun"));
                        lsabsen.setKeterangan(jsonObject.getString("keterangan"));
                        lsabsen.setLinkfoto(jsonObject.getString("foto"));
                        daftarabsen.add(lsabsen);
                    }catch (JSONException e){

                        e.printStackTrace();

                    }

                }

                setuprecycleview(daftarabsen);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        appController.getInstance().addToRequestQue(ArrayRequest);
    }

    private void setuprecycleview(List<listabsen> daftarabsen) {
        //list adapter nama kelas di adapter
        listadapter myadapter = new listadapter(this,daftarabsen);
        myrv.setLayoutManager(new LinearLayoutManager(this));
        myrv.setAdapter(myadapter);

    }

}
