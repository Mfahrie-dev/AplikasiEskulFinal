package com.aplikasikeluhan.aplikasieskulsiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aplikasikeluhan.aplikasieskulsiswa.Model.EskulModel;
import com.aplikasikeluhan.aplikasieskulsiswa.Service.GabungEskulService;
import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Detil extends AppCompatActivity {

    TextView JAM,JENIS,BIAYA,TENTANG;
    ImageView Gambar;
    String foto;
    int id;

    public static  final String MyPreferences   ="Mypref";    // tempat menyimpan data lokal

    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detil);
        init();
        get_data();
        Glide.with(Detil.this)
                .load(foto)
                .centerCrop()
                .placeholder(R.drawable.ic_baseline_home_24)
                .into(Gambar);

    }
    public void init (){
        //JAM =findViewById(R.id.tv_jam_eskul);
        JENIS =findViewById(R.id.nama_eskul);
        BIAYA =findViewById(R.id.biaya_eskul);
        TENTANG =findViewById(R.id.tentang_eskul);
        Gambar =findViewById(R.id.banner);
        preferences =getSharedPreferences(MyPreferences, Context.MODE_PRIVATE);
    }

    public void get_data(){

        int biaya;
        Intent intent =getIntent();
        biaya =intent.getIntExtra("biaya",5000);
        id=intent.getIntExtra("id_eskul",0);

        //JAM.setText(intent.getStringExtra("jam"));

        JENIS.setText(intent.getStringExtra("eskul"));
        BIAYA.setText("Biaya per bulan "+biaya);
        TENTANG.setText(intent.getStringExtra("tentang"));
        this.foto =intent.getStringExtra("foto");
    }


    public void join_eskul(View view) {
        GabungEskulService.join_eskul().insert_eskul(id,preferences.getInt("NISN",0)).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),response.body(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}