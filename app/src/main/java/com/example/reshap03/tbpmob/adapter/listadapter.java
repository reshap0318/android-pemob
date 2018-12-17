package com.example.reshap03.tbpmob.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.reshap03.tbpmob.activities.DetailAbsenActivity;
import com.example.reshap03.tbpmob.model.listabsen;

import java.util.List;
import com.example.reshap03.tbpmob.R;

public class listadapter extends RecyclerView.Adapter<listadapter.MyviewHolder> {

    private Context mContext;
    private List<listabsen> mdata;

    public listadapter(Context mContext, List<listabsen> mdata) {
        this.mContext = mContext;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.absenrow,viewGroup,false);
        final MyviewHolder viewholder = new MyviewHolder(view);

        viewholder.view_contain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, DetailAbsenActivity.class);
                //nama, menit di ambil dari id di row, dan get nama datang dari model
                i.putExtra("nama", mdata.get(viewholder.getAdapterPosition()).getNama());
                i.putExtra("menit", mdata.get(viewholder.getAdapterPosition()).getMenit());
                i.putExtra("jadwal", mdata.get(viewholder.getAdapterPosition()).getJadwal());
                i.putExtra("tanggal", mdata.get(viewholder.getAdapterPosition()).getTanggal());
                i.putExtra("bulan", mdata.get(viewholder.getAdapterPosition()).getBulan());
                i.putExtra("tahun", mdata.get(viewholder.getAdapterPosition()).getTahun());
                i.putExtra("keterangan", mdata.get(viewholder.getAdapterPosition()).getKeterangan());
                i.putExtra("img_url", mdata.get(viewholder.getAdapterPosition()).getLinkfoto());

                mContext.startActivity(i);

            }
        });

        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder myviewHolder, int i) {
        myviewHolder.tv_nama.setText(mdata.get(i).getNama());
        myviewHolder.tv_menit.setText(mdata.get(i).getMenit());
        myviewHolder.tv_jadwal.setText(mdata.get(i).getJadwal());
        myviewHolder.tv_bulan.setText(mdata.get(i).getBulan());
        myviewHolder.tv_tanggal.setText(mdata.get(i).getTanggal());
        myviewHolder.tv_tahun.setText(mdata.get(i).getTahun());
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder {

        TextView tv_bulan;
        TextView tv_tanggal;
        TextView tv_tahun;
        TextView tv_nama;
        TextView tv_menit;
        TextView tv_jadwal;
        TextView img_view;
        LinearLayout view_contain;


        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            view_contain = itemView.findViewById(R.id.rowcontain);
            tv_bulan = itemView.findViewById(R.id.bulan);
            tv_tanggal = itemView.findViewById(R.id.tanggal);
            tv_tahun = itemView.findViewById(R.id.tahun);
            tv_nama = itemView.findViewById(R.id.nama);
            tv_menit = itemView.findViewById(R.id.menit);
            tv_jadwal = itemView.findViewById(R.id.jadwal);
        }
    }
}
