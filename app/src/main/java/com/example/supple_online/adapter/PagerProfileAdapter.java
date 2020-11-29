package com.example.supple_online.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.supple_online.profile_fragment.CoachFragment;
import com.example.supple_online.profile_fragment.UserFragment;

public class PagerProfileAdapter extends FragmentPagerAdapter {
    public PagerProfileAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new UserFragment();
                break;
            case 1:
                fragment = new CoachFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "             Học Viên             ";
                break;
            case 1:
                title = "            HLV             ";
                break;
        }
        return title;
    }
}
