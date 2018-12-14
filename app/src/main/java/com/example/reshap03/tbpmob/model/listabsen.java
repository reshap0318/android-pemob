package com.example.reshap03.tbpmob.model;

public class listabsen {

    public String bulan;
    public String tanggal;
    public String tahun;
    public String nama;
    public String menit;
    public String jadwal;
    public String keterangan;

    public listabsen() {
    }

    public listabsen(String bulan, String tanggal, String tahun, String nama, String menit, String jadwal, String keterangan) {
        this.bulan = bulan;
        this.tanggal = tanggal;
        this.tahun = tahun;
        this.nama = nama;
        this.menit = menit;
        this.jadwal = jadwal;
        this.keterangan = keterangan;
    }

    public String getBulan() {
        return bulan;
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
}
