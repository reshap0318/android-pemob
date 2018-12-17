package com.example.reshap03.tbpmob.model;

public class listabsen {

    public String bulan;
    public String tanggal;
    public String tahun;
    public String nama;
    public String menit;
    public String jadwal;
    public String keterangan;
    public String linkfoto;

    public listabsen() {
    }

    public listabsen(String bulan, String tanggal, String tahun, String nama, String menit, String jadwal, String keterangan, String linkfoto) {
        this.bulan = bulan;
        this.tanggal = tanggal;
        this.tahun = tahun;
        this.nama = nama;
        this.menit = menit;
        this.jadwal = jadwal;
        this.keterangan = keterangan;
        this.linkfoto = linkfoto;
    }

    public String getBulan() {
        String pesan = null;
        if(bulan.equals("1")){
            pesan = "Januari";
        }else if(bulan.equals("2")){
            pesan = "Februari";
        }else if(bulan.equals("3")){
            pesan = "Maret";
        }else if(bulan.equals("4)")){
            pesan = "April";
        }else if(bulan.equals("5")){
            pesan = "Mei";
        }else if(bulan.equals("6")){
            pesan = "Juni";
        }else if(bulan.equals("7")){
            bulan = "Juli";
        }else if(bulan.equals("8")){
            pesan = "Agustus";
        }else if(bulan.equals("9")){
            pesan = "September";
        }else if(bulan.equals("10")){
            pesan = "Oktober";
        }else if(bulan.equals("11")){
            pesan = "November";
        }else if(bulan.equals("12")){
            pesan = "Desember";
        }
        return pesan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMenit() {
        return menit;
    }

    public void setMenit(String menit) {
        this.menit = menit;
    }

    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getLinkfoto() {
        return linkfoto;
    }

    public void setLinkfoto(String linkfoto) {
        this.linkfoto = linkfoto;
    }
}
