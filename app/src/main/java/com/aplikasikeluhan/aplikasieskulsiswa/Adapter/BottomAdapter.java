package com.aplikasikeluhan.aplikasieskulsiswa.Adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.aplikasikeluhan.aplikasieskulsiswa.Fragments.GabungEskulFragment;
import com.aplikasikeluhan.aplikasieskulsiswa.Fragments.HomeFragment;
import com.aplikasikeluhan.aplikasieskulsiswa.Fragments.ProfileFragment;

public class BottomAdapter extends FragmentStatePagerAdapter {

    Context context;
    int ItemCount;

    public BottomAdapter(@NonNull FragmentManager fm, Context context, int itemCount) {
        super(fm);
        this.context = context;
        ItemCount = itemCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return  new HomeFragment();
        }
        if (position == 1){
            return  new GabungEskulFragment();
        }
        if (position == 2){
            return  new ProfileFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return ItemCount;
    }
}
