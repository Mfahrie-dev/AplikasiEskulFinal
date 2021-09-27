package com.aplikasikeluhan.aplikasieskulsiswa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.aplikasikeluhan.aplikasieskulsiswa.Adapter.BottomAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity {

    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;
    TextView headerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        viewPager           =   findViewById(R.id.viewpager);
        bottomNavigationView=   findViewById(R.id.bottomNavigationView);
        headerText          =   findViewById(R.id.header_textview);

        viewPager.setAdapter(new BottomAdapter(getSupportFragmentManager(), DashboardActivity.this, 3));

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.Home){
                    viewPager.setCurrentItem(0);
                }
                if (item.getItemId() == R.id.Eskul){
                    viewPager.setCurrentItem(1);
                }
                if (item.getItemId() == R.id.Profile){
                    viewPager.setCurrentItem(2);
                }
                return false;
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                if (position == 0){
                    bottomNavigationView.setSelectedItemId(R.id.Home);
                    headerText.setText("Dashboard");
                }
                if (position == 1){
                    bottomNavigationView.setSelectedItemId(R.id.Eskul);
                    headerText.setText("Gabung Eskul");
                }
                if (position == 2){
                    bottomNavigationView.setSelectedItemId(R.id.Profile);
                    headerText.setText("Profile Kamu");
                }

            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}