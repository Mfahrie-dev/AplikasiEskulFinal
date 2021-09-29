package com.aplikasikeluhan.aplikasieskulsiswa.FragmentsHome;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aplikasikeluhan.aplikasieskulsiswa.Adapter.get_siswa_eskul;
import com.aplikasikeluhan.aplikasieskulsiswa.Model.Get_siswa_eskulModel;
import com.aplikasikeluhan.aplikasieskulsiswa.R;
import com.aplikasikeluhan.aplikasieskulsiswa.Service.Siswa_eskulService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MyEskulFragment extends Fragment {

    RecyclerView rc;
    SharedPreferences sharedPreferences;
    SwipeRefreshLayout refreshLayout;
    get_siswa_eskul adapter;

    public static  final String MyPreferences   ="Mypref";

    public MyEskulFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view   = inflater.inflate(R.layout.fragment_my_eskul, container, false);

        rc = view.findViewById(R.id.home_recycleview);

        sharedPreferences =getContext().getSharedPreferences(MyPreferences, Context.MODE_PRIVATE);

        adapter = new get_siswa_eskul();

        rc.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rc.setLayoutManager(layoutManager);
        get_data();

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        get_data();
                    }
                }, 2000);
            }
        });



        return view;
    }
    public void get_data(){
        Siswa_eskulService.eskul_siswa().get_eskul(sharedPreferences.getInt("NISN",0)).enqueue(new Callback<List<Get_siswa_eskulModel>>() {
            @Override
            public void onResponse(Call<List<Get_siswa_eskulModel>> call, Response<List<Get_siswa_eskulModel>> response) {
                if (response.isSuccessful()){
                    List<Get_siswa_eskulModel> data1 =new ArrayList<Get_siswa_eskulModel>();
                    data1 =response.body();
                    adapter.setList(data1);
                }
            }
            @Override
            public void onFailure(Call<List<Get_siswa_eskulModel>> call, Throwable t) {

            }
        });
    }
}