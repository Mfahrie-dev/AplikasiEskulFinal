package com.aplikasikeluhan.aplikasieskulsiswa.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aplikasikeluhan.aplikasieskulsiswa.Adapter.AllEskulAdapter;
import com.aplikasikeluhan.aplikasieskulsiswa.Model.EskulModel;
import com.aplikasikeluhan.aplikasieskulsiswa.R;
import com.aplikasikeluhan.aplikasieskulsiswa.Service.GabungEskulService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GabungEskulFragment extends Fragment {
    RecyclerView rc;
    AllEskulAdapter adapter;

    public GabungEskulFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gabung_eskul, container, false);
        rc        = view.findViewById(R.id.gabung_eskul_rc);
        adapter =new AllEskulAdapter(getContext());


        rc.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rc.setLayoutManager(layoutManager);
        get_data();

        return view;
    }

    public void get_data(){
        GabungEskulService.gabungEskul().join_eskul().enqueue(new Callback<List<EskulModel>>() {
            @Override
            public void onResponse(Call<List<EskulModel>> call, Response<List<EskulModel>> response) {
                List<EskulModel> data =response.body();
                if (response.isSuccessful()){
                    adapter.setList(data);
                }
            }

            @Override
            public void onFailure(Call<List<EskulModel>> call, Throwable t) {

            }
        });


    }
}