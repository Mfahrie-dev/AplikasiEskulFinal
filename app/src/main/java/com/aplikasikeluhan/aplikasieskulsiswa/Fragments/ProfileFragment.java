package com.aplikasikeluhan.aplikasieskulsiswa.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aplikasikeluhan.aplikasieskulsiswa.R;


public class ProfileFragment extends Fragment {

    TextView NAMA,EMAIL,NISN;
    SharedPreferences sharedPreferences;
    public static  final String MyPreferences   ="Mypref";    // tempat menyimpan data lokal
    public static final String Primary ="KeyValue";  // key untuk data yang di input



    public ProfileFragment() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_profile, container, false);

        NAMA  = view.findViewById(R.id.nama_user);
        EMAIL = view.findViewById(R.id.email_user);
        NISN  = view.findViewById(R.id.nisn_user);

        sharedPreferences =getContext().getSharedPreferences(MyPreferences, Context.MODE_PRIVATE);

        NAMA.setText(sharedPreferences.getString("NAMA",""));
        NISN.setText(""+sharedPreferences.getInt("NISN",0));
        EMAIL.setText(sharedPreferences.getString("EMAIL",""));

        return view;
    }

}