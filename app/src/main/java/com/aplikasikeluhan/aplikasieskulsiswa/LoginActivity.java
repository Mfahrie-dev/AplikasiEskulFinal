package com.aplikasikeluhan.aplikasieskulsiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void keRegister(View view) {
        Intent intent   =   new Intent();
        intent.setClass(getApplicationContext(), RegisterActivity.class);
        startActivity(intent);
    }

    public void keDashboard(View view) {
        Intent intent   =   new Intent();
        intent.setClass(getApplicationContext(), DashboardActivity.class);
        startActivity(intent);
    }
}