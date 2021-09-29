package com.aplikasikeluhan.aplikasieskulsiswa.Service;

import com.aplikasikeluhan.aplikasieskulsiswa.Api.GabungEskul;
import com.aplikasikeluhan.aplikasieskulsiswa.Api.SiswaApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class GabungEskulService {
    //private static String BASE_URL="https://demo.lazday.com/rest-api-sample/";

    // membuat objek retrofit
    private static Retrofit retrofit;
    final  static  String Base = "https://ublmobilekmmi.web.id/";

    // objek interface endpoint
    // return endpoint yang ada pada interface
    public static GabungEskul gabungEskul(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Base)
                .addConverterFactory(GsonConverterFactory.create())
//                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        return  retrofit.create(GabungEskul.class);
    }
    public static GabungEskul join_eskul(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Base)
                //.addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        return  retrofit.create(GabungEskul.class);
    }
}
