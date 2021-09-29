package com.aplikasikeluhan.aplikasieskulsiswa.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EskulModel {
    @SerializedName("id_eskul")
    private int id;

    @SerializedName("nama_eskul")
    private String ekskul;

    @SerializedName("bayaran")
    private int biaya ;

    @SerializedName("hari")
    private  String hari;

    @SerializedName("jam")
    private  String jam;

    @SerializedName("fotoEskul")
    private String gambar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getTentang() {
        return tentang;
    }



    public void setTentang(String tentang) {
        this.tentang = tentang;
    }

    @SerializedName("tentang")
    private  String tentang;

    public String getEkskul() {
        return ekskul;
    }

    public void setEkskul(String ekskul) {
        this.ekskul = ekskul;
    }

    public int getBiaya() {
        return biaya;
    }

    public void setBiaya(int biaya) {
        this.biaya = biaya;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public List<EskulModel> getData() {
        return data;
    }

    public void setData(List<EskulModel> data) {
        this.data = data;
    }

    private List<EskulModel> data;
}
