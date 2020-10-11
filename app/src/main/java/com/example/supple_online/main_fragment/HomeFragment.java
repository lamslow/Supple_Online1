package com.example.supple_online.main_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.supple_online.R;
import com.example.supple_online.screen.CartActivity;
import com.example.supple_online.screen.MallActivity;
import com.example.supple_online.screen.SearchActivity;

public class HomeFragment extends Fragment {

    private ViewFlipper viewFlipper;
    private LinearLayout liner;
    private Button btnSearch;
    private ImageButton btnCart;
    private TextView tvNumberInCart;
    private RecyclerView rvSuppleProduct;
    private LinearLayout lnWhey;
    private LinearLayout lnMass;
    private LinearLayout lnBCAA;
    private TextView tvMore;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        int images[] = {R.drawable.banner1, R.drawable.banner2, R.drawable.banner3};
        for (int image : images) {
            flipperImages(image);
        }

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CartActivity.class);
                startActivity(intent);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });

        tvMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), MallActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    public void flipperImages(int image) {
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(image);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(2500);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(getContext(), android.R.anim.fade_in);
    }

    private void initView(View view) {
        lnWhey = (LinearLayout) view.findViewById(R.id.lnWhey);
        lnMass = (LinearLayout) view.findViewById(R.id.lnMass);
        lnBCAA = (LinearLayout) view.findViewById(R.id.lnBCAA);
        tvMore = (TextView) view.findViewById(R.id.tvMore);

        liner = (LinearLayout) view.findViewById(R.id.liner);
        btnSearch = (Button) view.findViewById(R.id.btnSearch);
        btnCart = (ImageButton) view.findViewById(R.id.btnCart);
        tvNumberInCart = (TextView) view.findViewById(R.id.tvNumberInCart);
        viewFlipper = (ViewFlipper) view.findViewById(R.id.vpSlider);
        rvSuppleProduct = (RecyclerView) view.findViewById(R.id.rvSuppleProduct);
    }
}
