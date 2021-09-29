package com.aplikasikeluhan.aplikasieskulsiswa.Api;

import com.aplikasikeluhan.aplikasieskulsiswa.Model.SiswaModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SiswaApi {

    @FormUrlEncoded
    @POST("APLIKASI_ESKUL/SISWA/insertSiswa.php")
    Call<String> insertSiswa(
            @Field("nisn") int nisn,
            @Field("nama") String nama,
            @Field("password") String password,
            @Field("email") String email
    );

    @GET("APLIKASI_ESKUL/SISWA/getSiswa.php")
    Call<SiswaModel> validate_login(@Query("nisn") int nisn, @Query("password") String password);

    @GET("APLIKASI_ESKUL/SISWA/getSiswa.php")
    Call<SiswaModel> profil(@Query("nisn") int nisn);
}
