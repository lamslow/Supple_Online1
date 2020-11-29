package com.example.supple_online.profile_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.supple_online.R;
import com.example.supple_online.screen.profile_screen.MyOrderActivity;

public class UserFragment extends Fragment {
    private TextView tvUserInfor;
    private TextView tvMyOrder;
    private TextView tvChangePassword;
    private TextView tvUsualQuestion;
    private TextView tvSecurity;
    private TextView tvSignOut;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);
        initView(view);
        tvMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MyOrderActivity.class);
                startActivity(intent);
            }
        });



        return view;
    }

    private void initView(View view) {
        tvUserInfor = (TextView) view.findViewById(R.id.tvUserInfor);
        tvMyOrder = (TextView) view.findViewById(R.id.tvMyOrder);
        tvChangePassword = (TextView) view.findViewById(R.id.tvChangePassword);
        tvUsualQuestion = (TextView) view.findViewById(R.id.tvUsualQuestion);
        tvSecurity = (TextView) view.findViewById(R.id.tvSecurity);
        tvSignOut = (TextView) view.findViewById(R.id.tvSignOut);
    }
}
