package com.aplikasikeluhan.aplikasieskulsiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.aplikasikeluhan.aplikasieskulsiswa.Api.SiswaApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    private EditText nisn,nama,password,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nisn    =   findViewById(R.id.editText_nisn);
        nama    =   findViewById(R.id.editText_nama);
        password=   findViewById(R.id.editText_password);
        email   =   findViewById(R.id.editText_email);

    }

    public void keLogin(View view) {
        finish();
    }

    public void insertSiswa(View view) {
        Retrofit retrofit   =   new Retrofit.Builder()
                .baseUrl(getString(R.string.base_url))
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        SiswaApi siswaApi       =   retrofit.create(SiswaApi.class);
        Call<String> call       =   siswaApi.insertSiswa(
                Integer.parseInt(nisn.getText().toString()),
                        nama.getText().toString(),
                        password.getText().toString(),
                        email.getText().toString());

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), response.body(),
                            Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), response.toString(),
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(),
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
}