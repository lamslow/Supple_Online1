package com.example.supple_online.profile_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.supple_online.R;

public class MyOrderFragment extends Fragment {
    private RecyclerView rcvMyOrder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_order, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        rcvMyOrder = (RecyclerView) view.findViewById(R.id.rcvMyOrder);
    }
}
