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

import com.example.supple_online.R;
import com.example.supple_online.main_fragment.HomeFragment;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {
    private CardView cvAvatarProfile;
    private TextView tvNameProfile;
    private TextView tvCapacity;
    private LinearLayout llPhoneProfile;
    private LinearLayout llAddressProfile;
    private CircleImageView imvAvatarProfile;
    private TextView tvMyOrder;
    private TextView tvChangePassword;
    private TextView tvUsualQuestion;
    private TextView tvSecurity;
    private TextView tvSignOut;
    private ImageView imvBackInProfile;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        initView(view);

        tvMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOrderFragment myOrderFragment = new MyOrderFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, myOrderFragment, "toMyOrderFragment")
                        .addToBackStack(null).commit();
            }
        });

        imvBackInProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragment homeFragment = new HomeFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, homeFragment, "backToHomeFragment")
                        .addToBackStack(null).commit();
            }
        });
        return view;
    }

    private void initView(View view) {
        tvNameProfile = (TextView) view.findViewById(R.id.tvNameProfile);
        tvCapacity = (TextView) view.findViewById(R.id.tvCapacity);
        llPhoneProfile = (LinearLayout) view.findViewById(R.id.llPhoneProfile);
        llAddressProfile = (LinearLayout) view.findViewById(R.id.llAddressProfile);
        imvAvatarProfile = (CircleImageView) view.findViewById(R.id.imvAvatarProfile);
        tvMyOrder = (TextView) view.findViewById(R.id.tvMyOrder);
        tvChangePassword = (TextView) view.findViewById(R.id.tvChangePassword);
        tvUsualQuestion = (TextView) view.findViewById(R.id.tvUsualQuestion);
        tvSecurity = (TextView) view.findViewById(R.id.tvSecurity);
        tvSignOut = (TextView) view.findViewById(R.id.tvSignOut);
        imvBackInProfile = (ImageView) view.findViewById(R.id.imvBackInProfile);
    }
}
