package com.aplikasikeluhan.aplikasieskulsiswa.Service;

import com.aplikasikeluhan.aplikasieskulsiswa.Api.SiswaApi;
import com.aplikasikeluhan.aplikasieskulsiswa.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class LoginService {
    //private static String BASE_URL="https://demo.lazday.com/rest-api-sample/";

    // membuat objek retrofit
    private static Retrofit retrofit;
    final  static  String Base = "https://ublmobilekmmi.web.id/";

    // objek interface endpoint
    // return endpoint yang ada pada interface
    public static SiswaApi siswaApi(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Base)
                .addConverterFactory(GsonConverterFactory.create())
//                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        return  retrofit.create(SiswaApi.class);
    }
}
