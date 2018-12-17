package com.example.reshap03.tbpmob.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

import java.util.HashMap;
import java.util.Map;

public class AbsenActivity extends AppCompatActivity {

   EditText nama, keterangan;
   Button fbupload, fbsimpan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absen);

        nama = (EditText) findViewById(R.id.fnama);
        keterangan = (EditText) findViewById(R.id.fketerangan);
        fbupload = (Button) findViewById(R.id.fupload);
        fbsimpan = (Button) findViewById(R.id.fsubmit);

    }

    private void simpandata(){
        StringRequest simpan = new StringRequest(Request.Method.POST, serverapi.create_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(AbsenActivity.this,"Gagal", Toast.LENGTH_SHORT);
                try {
                    JSONObject res = new JSONObject(response);
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
                map.put("nama", nama.getText().toString());
                map.put("keterangan", keterangan.getText().toString());
                return super.getParams();
            }
        };


    }
}
