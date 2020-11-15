package com.example.supple_online.screen;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.supple_online.R;
import com.example.supple_online.helper.BaseActivity;
import com.example.supple_online.main_fragment.FindFragment;
import com.example.supple_online.main_fragment.HomeFragment;
import com.example.supple_online.main_fragment.MallFragment;
import com.example.supple_online.main_fragment.MapFragment;
import com.example.supple_online.main_fragment.NotificationFrament;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeCoachActivity extends BaseActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectFragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectFragment = new HomeFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, selectFragment).commit();
                    break;
                case R.id.navigation_mall:
//                    selectFragment = new MallFragment();
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, selectFragment).commit();
                    break;
                case R.id.navigation_notifications:
//                    selectFragment = new NotificationFrament();
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, selectFragment).commit();
//                    break;
                case R.id.navigation_map:
//                    selectFragment = new MapFragment();
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, selectFragment).commit();
//                    break;
            }
            return true;
        }
    };

    @Override
    public void onBackPressed() {
        return;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_coach);
        BottomNavigationView navigation_coach = findViewById(R.id.navigationCoach);
        navigation_coach.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout_coach, new HomeFragment());
    }
}