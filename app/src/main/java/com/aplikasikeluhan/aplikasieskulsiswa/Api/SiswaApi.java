package com.aplikasikeluhan.aplikasieskulsiswa.Api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SiswaApi {

    @FormUrlEncoded
    @POST("APLIKASI_ESKUL/SISWA/insertSiswa.php")
    Call<String> insertSiswa(
            @Field("nisn") int nisn,
            @Field("nama") String nama,
            @Field("password") String password,
            @Field("email") String email
    );
}
