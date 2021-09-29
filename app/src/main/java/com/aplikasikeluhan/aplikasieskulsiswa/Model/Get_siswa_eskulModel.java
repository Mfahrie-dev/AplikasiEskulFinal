package com.aplikasikeluhan.aplikasieskulsiswa.Model;

import com.google.gson.annotations.SerializedName;

public class Get_siswa_eskulModel {
    @SerializedName("nama_eskul")
    private String eskul;

    @SerializedName("jam")
    private String jam;

    @SerializedName("hari")
    private String hari;

    public String getEskul() {
        return eskul;
    }

    public void setEskul(String eskul) {
        this.eskul = eskul;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }
}
