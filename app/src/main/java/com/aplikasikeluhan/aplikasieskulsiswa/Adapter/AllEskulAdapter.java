package com.aplikasikeluhan.aplikasieskulsiswa.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.aplikasikeluhan.aplikasieskulsiswa.Detil;
import com.aplikasikeluhan.aplikasieskulsiswa.Model.EskulModel;
import com.aplikasikeluhan.aplikasieskulsiswa.R;

import java.util.ArrayList;
import java.util.List;

public class AllEskulAdapter extends RecyclerView.Adapter<AllEskulAdapter.holder> {
Context context;
    public AllEskulAdapter(Context context){
        this.context =context;
    }
    private List<EskulModel> value = new ArrayList<EskulModel>();


    // method unutk mengisi list
    public  void setList(List<EskulModel> param){
        this.value.addAll(param);
        // untuk merefresh perubahan yang di lakukan
        this.notifyDataSetChanged();
    }


    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gabung_adapter, parent,
                        false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.setdata(value.get(position));

        holder.main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detil_eskul =new Intent(context, Detil.class);
                detil_eskul.putExtra("id_eskul",value.get(position).getId());
                detil_eskul.putExtra("biaya",value.get(position).getBiaya());
                detil_eskul.putExtra("eskul",value.get(position).getEkskul());
                detil_eskul.putExtra("jam",value.get(position).getJam());
                detil_eskul.putExtra("foto",value.get(position).getGambar());
                detil_eskul.putExtra("tentang",value.get(position).getTentang());
                context.startActivity(detil_eskul);
            }
        });
    }

    @Override
    public int getItemCount() {
        return value.size();
    }

    public class holder extends RecyclerView.ViewHolder {
            TextView ESKUL,JAM,HARI;
            ConstraintLayout main;


        public holder(@NonNull View itemView) {
            super(itemView);
            ESKUL = itemView.findViewById(R.id.tv_nama_eskul);
            JAM   = itemView.findViewById(R.id.tv_jam_eskul);
            HARI  = itemView.findViewById(R.id.tv_hari);
            main  = itemView.findViewById(R.id.main_eskul);
        }
        public void setdata(EskulModel param){
            ESKUL.setText(param.getEkskul());
            JAM.setText(param.getJam());
            HARI.setText(param.getHari());
        }
    }
}
