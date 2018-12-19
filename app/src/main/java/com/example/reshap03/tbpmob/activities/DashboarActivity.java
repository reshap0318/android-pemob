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
        csenin = (CardView) findViewById(R.id.listabsen);
        cselasa = (CardView) findViewById(R.id.listfavorit);

        //add click
        cabsen.setOnClickListener(this);
        csenin.setOnClickListener(this);
        cselasa.setOnClickListener(this);

        //hide action bar
        getSupportActionBar().hide();

    }

    @Override
    public void onClick(View v) {
        Intent intent ;

        switch (v.getId()){
            case R.id.absen : intent = new Intent(DashboarActivity.this, AbsenActivity.class);startActivity(intent);break;
            case R.id.listabsen : intent = new Intent(DashboarActivity.this, ListAbsenActivity.class);startActivity(intent);break;
            case R.id.listfavorit : intent = new Intent(DashboarActivity.this, ListActivity.class);startActivity(intent);break;
        }
    }

}
