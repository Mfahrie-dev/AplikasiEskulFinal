package com.aplikasikeluhan.aplikasieskulsiswa.Api;

import com.aplikasikeluhan.aplikasieskulsiswa.Model.EskulModel;
import com.aplikasikeluhan.aplikasieskulsiswa.Model.SiswaModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GabungEskul {
    @GET("APLIKASI_ESKUL/ESKUL/AllEkskul.php")
    Call<List<EskulModel>> join_eskul ();

    @FormUrlEncoded
    @POST("APLIKASI_ESKUL/ESKUL/join_eskul.php")
    Call<String> insert_eskul (@Field("id_eskul") int id_eskul, @Field("nisn") int nisn);
}
