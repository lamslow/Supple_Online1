package com.example.supple_online.mall_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.supple_online.R;
import com.example.supple_online.main_fragment.MallFragment;

public class SuppleFragment extends Fragment {

    private Spinner spnSapXepBCAA;
    private RecyclerView rvBCAADeals;
    private ImageView imvBackInMallProduct;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mall_product, container, false);
        initView(view);
        imvBackInMallProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MallFragment mallFragment = new MallFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, mallFragment, "backToMallFromSupple").addToBackStack(null).commit();
            }
        });
        return view;
    }

    private void initView(View view) {
        spnSapXepBCAA = (Spinner) view.findViewById(R.id.spnSort);
        rvBCAADeals = (RecyclerView) view.findViewById(R.id.rvDeals);
        imvBackInMallProduct = (ImageView)  view.findViewById(R.id.imvBackInMallProduct);
    }
}
