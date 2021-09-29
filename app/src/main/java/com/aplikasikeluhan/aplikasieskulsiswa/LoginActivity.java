package com.aplikasikeluhan.aplikasieskulsiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.aplikasikeluhan.aplikasieskulsiswa.Model.SiswaModel;
import com.aplikasikeluhan.aplikasieskulsiswa.Service.LoginService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    public static  final String MyPreferences   ="Mypref";    // tempat menyimpan data lokal
    public static final String Primary ="NISN";

    // objek sharepreferences
    SharedPreferences preferences;

    // objek edittext
    private EditText nisn,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    public void keRegister(View view) {
        Intent intent   =   new Intent();
        intent.setClass(getApplicationContext(), RegisterActivity.class);
        startActivity(intent);
    }

    public void keDashboard(View view) {
        int param_nisn =Integer.parseInt(nisn.getText().toString());
        LoginService.siswaApi().validate_login(param_nisn,password.getText().toString()).enqueue(new Callback<SiswaModel>() {
            @Override
            public void onResponse(Call<SiswaModel> call, Response<SiswaModel> response) {
                if (response.isSuccessful()){
                    String email =response.body().getEmail();
                    if (email.equals("tidak ada")){
                        Toast.makeText(getApplicationContext(),"Login Gagal",Toast.LENGTH_LONG).show();
                    }else{
                        SharedPreferences.Editor editor = preferences.edit();
                         editor.putInt("NISN",response.body().getNisn());
                         editor.putString("EMAIL",response.body().getEmail());
                         editor.putString("NAMA",response.body().getNama());
                        editor.commit();

                        startActivity(new Intent(LoginActivity.this,DashboardActivity.class));
                        Toast.makeText(getApplicationContext(),"BERHASIL",Toast.LENGTH_LONG).show();
                    }

                }
                /*
                if (response.isSuccessful() ){
                    List<SiswaModel> data =response.body();
                    String email =data.get(0).getEmail();
                    Toast.makeText(getApplicationContext(),email,Toast.LENGTH_LONG).show();


                    if (!email.isEmpty()){
                        SharedPreferences.Editor editor = preferences.edit();
                        // editor.putInt(Primary,response.body().getNisn());
                        editor.commit();
//                    Toast.makeText(getApplicationContext(), response.body().ge, Toast.LENGTH_LONG).show();
                        startActivity(new Intent(LoginActivity.this,DashboardActivity.class));
                        Toast.makeText(getApplicationContext(),"BERHASIL",Toast.LENGTH_LONG).show();
                    }


                }else{
                    Toast.makeText(getApplicationContext(),"GAGAL",Toast.LENGTH_LONG).show();
                }

                 */




            }

            @Override
            public void onFailure(Call<SiswaModel> call, Throwable t) {

            }
        });
        /*

        LoginService.siswaApi().validate_login(param_nisn,password.getText().toString()).enqueue(new Callback<List<SiswaModel>>() {
            @Override
            public void onResponse(Call<List<SiswaModel>> call, Response<List<SiswaModel>> response) {

                if (response.isSuccessful() && response.body().contains("nisn")) {

                    //String hasil = response.body();




                } else{
                    Toast.makeText(getApplicationContext(), "Anda tidak terdaftar", Toast.LENGTH_LONG).show();


                    }



            }

            @Override
            public void onFailure(Call<List<SiswaModel>> call, Throwable t) {

            }
        });

         */

    }

    public void init(){
        nisn =findViewById(R.id.editText_nisn);
        password =findViewById(R.id.editText_password);
        preferences =getSharedPreferences(MyPreferences, Context.MODE_PRIVATE);
    }
}