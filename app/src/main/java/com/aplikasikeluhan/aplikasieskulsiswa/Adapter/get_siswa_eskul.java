package com.aplikasikeluhan.aplikasieskulsiswa.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.aplikasikeluhan.aplikasieskulsiswa.Model.EskulModel;
import com.aplikasikeluhan.aplikasieskulsiswa.Model.Get_siswa_eskulModel;
import com.aplikasikeluhan.aplikasieskulsiswa.R;

import java.util.ArrayList;
import java.util.List;

public  class get_siswa_eskul extends RecyclerView.Adapter<get_siswa_eskul.Homeholder> {

    public List<Get_siswa_eskulModel> value =new ArrayList<Get_siswa_eskulModel>();

    public  void setList(List<Get_siswa_eskulModel> param){
        this.value.addAll(param);
        // untuk merefresh perubahan yang di lakukan
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Homeholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gabung_adapter, parent,
                false);
        return new Homeholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Homeholder holder, int position) {
          holder.setdata(value.get(position));
    }

    @Override
    public int getItemCount() {
        return value.size();
    }

    public class Homeholder extends RecyclerView.ViewHolder{
        TextView ESKUL,JAM,HARI;
        public Homeholder(@NonNull View itemView) {
            super(itemView);
            ESKUL = itemView.findViewById(R.id.tv_nama_eskul);
            JAM   = itemView.findViewById(R.id.tv_jam_eskul);
            HARI  =itemView.findViewById(R.id.tv_hari);

        }
        public void setdata(Get_siswa_eskulModel param){
            ESKUL.setText(param.getEskul());
            JAM.setText(param.getJam());
            HARI.setText(param.getHari());
        }
    }
}
