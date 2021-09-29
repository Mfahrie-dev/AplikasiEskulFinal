package com.aplikasikeluhan.aplikasieskulsiswa.Api;

import com.aplikasikeluhan.aplikasieskulsiswa.Model.Get_siswa_eskulModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface get_siswa_eskul {

    @GET("APLIKASI_ESKUL/SISWA/get_eskul_siswa.php")
    Call<List<Get_siswa_eskulModel>> get_eskul(@Query("nisn") int nisn);
}
