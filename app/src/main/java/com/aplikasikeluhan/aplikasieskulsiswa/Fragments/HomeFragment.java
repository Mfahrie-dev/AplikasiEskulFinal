package com.aplikasikeluhan.aplikasieskulsiswa.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aplikasikeluhan.aplikasieskulsiswa.Adapter.get_siswa_eskul;
import com.aplikasikeluhan.aplikasieskulsiswa.Model.EskulModel;
import com.aplikasikeluhan.aplikasieskulsiswa.Model.Get_siswa_eskulModel;
import com.aplikasikeluhan.aplikasieskulsiswa.R;
import com.aplikasikeluhan.aplikasieskulsiswa.Service.GabungEskulService;
import com.aplikasikeluhan.aplikasieskulsiswa.Service.Siswa_eskulService;
import com.aplikasikeluhan.aplikasieskulsiswa.tabAdapter.TabAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        tabLayout       =   view.findViewById(R.id.tabLayout);
        viewPager       =   view.findViewById(R.id.viewpager);

        tabLayout.setupWithViewPager(viewPager);

        viewPager.setAdapter(new TabAdapter(getChildFragmentManager(), getContext(), 2));

        return  view;
    }

}