package com.example.supple_online.profile_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.example.supple_online.R;
import com.example.supple_online.adapter.PagerProfileAdapter;
import com.example.supple_online.main_fragment.HomeFragment;
import com.google.android.material.tabs.TabLayout;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {
    private CircleImageView imvAvatarProfile;
    private TextView tvNameProfile;
    private ImageView imvBackInProfile;
    private TabLayout tabLayoutProfile;
    private ViewPager viewPagerProfile;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        initView(view);

        imvBackInProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragment homeFragment = new HomeFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, homeFragment, "backToHomeFragment")
                        .addToBackStack(null).commit();
            }
        });

        FragmentManager manager = getActivity().getSupportFragmentManager();
        PagerProfileAdapter adapter = new PagerProfileAdapter(manager);
        viewPagerProfile.setAdapter(adapter);
        tabLayoutProfile.setupWithViewPager(viewPagerProfile);
        viewPagerProfile.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutProfile));
        tabLayoutProfile.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPagerProfile));
        return view;
    }

    private void initView(View view) {
        tvNameProfile = (TextView) view.findViewById(R.id.tvNameProfile);
        imvAvatarProfile = (CircleImageView) view.findViewById(R.id.imvAvatarProfile);
        imvBackInProfile = (ImageView) view.findViewById(R.id.imvBackInProfile);
        tabLayoutProfile = (TabLayout) view.findViewById(R.id.tab_layout_profile);
        viewPagerProfile = (ViewPager) view.findViewById(R.id.view_pager_profile);
    }
}
