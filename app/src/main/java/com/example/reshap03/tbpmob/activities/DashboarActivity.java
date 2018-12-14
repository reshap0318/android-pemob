package com.example.reshap03.tbpmob.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.reshap03.tbpmob.R;

public class DashboarActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView cabsen, csenin, cselasa, crabu, ckamis, cjumat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboar);

        //definisikan
        cabsen = (CardView) findViewById(R.id.absen);
        csenin = (CardView) findViewById(R.id.senin);
        cselasa = (CardView) findViewById(R.id.selasa);
        crabu = (CardView) findViewById(R.id.rabu);
        ckamis = (CardView) findViewById(R.id.kamis);
        cjumat = (CardView) findViewById(R.id.jumat);

        //add click
        cabsen.setOnClickListener(this);
        csenin.setOnClickListener(this);
        cselasa.setOnClickListener(this);
        crabu.setOnClickListener(this);
        ckamis.setOnClickListener(this);
        cjumat.setOnClickListener(this);

        //hide action bar
        getSupportActionBar().hide();

    }

    @Override
    public void onClick(View v) {
        Intent intent ;

        switch (v.getId()){
            case R.id.absen : intent = new Intent(DashboarActivity.this, AbsenActivity.class);
                startActivity(intent);break;
        }
    }

}
