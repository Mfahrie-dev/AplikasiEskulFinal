package com.aplikasikeluhan.aplikasieskulsiswa.tabAdapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.aplikasikeluhan.aplikasieskulsiswa.FragmentsHome.MyEskulFragment;
import com.aplikasikeluhan.aplikasieskulsiswa.FragmentsHome.MyFeedFragments;

public class TabAdapter extends FragmentStatePagerAdapter {

    Context context;
    int itemCount;

    public TabAdapter(@NonNull FragmentManager fm, Context context, int itemCount) {
        super(fm);
        this.context = context;
        this.itemCount = itemCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        if (position    ==  0){
            return new MyEskulFragment();
        }
        if (position    ==  1){
            return  new MyFeedFragments();
        }

        return null;
    }

    @Override
    public int getCount() {
        return itemCount;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if (position    ==  0){
            return "Esukl";
        }
        if (position    ==  1){
            return "Feed";
        }
        return null;

    }
}
