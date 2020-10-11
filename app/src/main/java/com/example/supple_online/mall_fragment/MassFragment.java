package com.example.supple_online.mall_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.supple_online.R;

import java.util.ArrayList;

public class MassFragment extends Fragment {
    private Spinner spnSapXepMass;
    private RecyclerView rvMassDeals;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mall_product, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        spnSapXepMass = (Spinner) view.findViewById(R.id.spnSapXep);
        rvMassDeals = (RecyclerView) view.findViewById(R.id.rvDeals);
    }

}
