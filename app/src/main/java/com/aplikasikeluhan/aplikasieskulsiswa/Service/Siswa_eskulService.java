package com.aplikasikeluhan.aplikasieskulsiswa.Service;


import com.aplikasikeluhan.aplikasieskulsiswa.Api.get_siswa_eskul;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Siswa_eskulService {
    //private static String BASE_URL="https://demo.lazday.com/rest-api-sample/";

    // membuat objek retrofit
    private static Retrofit retrofit;
    final  static  String Base = "https://ublmobilekmmi.web.id/";

    // objek interface endpoint
    // return endpoint yang ada pada interface
    public static get_siswa_eskul eskul_siswa(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Base)
                .addConverterFactory(GsonConverterFactory.create())
//                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        return  retrofit.create(get_siswa_eskul.class);
    }
}
