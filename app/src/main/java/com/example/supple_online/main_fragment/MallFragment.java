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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.supple_online.R;
import com.example.supple_online.adapter.ProductsAdapter;
import com.example.supple_online.mall_fragment.ClothesFragment;
import com.example.supple_online.mall_fragment.SuppleFragment;
import com.example.supple_online.mall_fragment.ToolsFragment;
import com.example.supple_online.model.Product;
import com.example.supple_online.screen.CartActivity;
import com.example.supple_online.screen.SearchActivity;

import java.util.ArrayList;
import java.util.List;

public class MallFragment extends Fragment {

    private Button btnMallSearch;
    private ImageButton btnMallCart;
    private TextView tvMallNumberInCart;
    private ViewFlipper vpFlipperImageMall;
    private GridLayoutManager gridLayoutManager;
    private RecyclerView rcvListHotProduct;
    private LinearLayout llSuppleFragment;
    private LinearLayout llClothesFragment;
    private LinearLayout llToolsFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mall, container, false);
        initView(view);
        getProduct();
        int images[] = {R.drawable.banner1, R.drawable.banner2, R.drawable.banner3};
        for (int image : images) {
            flipperImages(image);
        }

        btnMallSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });

        btnMallCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CartActivity.class);
                startActivity(intent);
            }
        });

        llSuppleFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SuppleFragment suppleFragment = new SuppleFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, suppleFragment, "toSuppleFragment")
                        .addToBackStack(null).commit();
            }
        });

        llClothesFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClothesFragment clothesFragment = new ClothesFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, clothesFragment, "toClothesFragment")
                        .addToBackStack(null).commit();
            }
        });

        llToolsFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToolsFragment toolsFragment = new ToolsFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, toolsFragment, "toToolsFragment")
                        .addToBackStack(null).commit();
            }
        });

        return view;
    }

    private void flipperImages(int image) {
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(image);
        vpFlipperImageMall.addView(imageView);
        vpFlipperImageMall.setFlipInterval(2500);
        vpFlipperImageMall.setAutoStart(true);
        vpFlipperImageMall.setInAnimation(getContext(), android.R.anim.fade_in);
    }

    private void initView(View view) {
        btnMallSearch = (Button) view.findViewById(R.id.btnMallSearch);
        btnMallCart = (ImageButton) view.findViewById(R.id.btnMallCart);
        tvMallNumberInCart = (TextView) view.findViewById(R.id.tvMallNumberInCart);
        vpFlipperImageMall = (ViewFlipper) view.findViewById(R.id.vpFlipperImageMall);
        rcvListHotProduct = (RecyclerView) view.findViewById(R.id.rcvListHotProduct);
        llSuppleFragment = (LinearLayout)  view.findViewById(R.id.llSuppleFragment);
        llClothesFragment = (LinearLayout)  view.findViewById(R.id.llClothesFragment);
        llToolsFragment = (LinearLayout)  view.findViewById(R.id.llToolsFragment);
    }

    ProductsAdapter productsAdapter;
    List<Product> productList;

    private void getProduct() {
        productList = new ArrayList<>();
        productList.clear();
        Product product = new Product("100% Whey Gold Standard 5lbs (2.3kg)", "1450000", R.drawable.product_1, "5");
        Product product2 = new Product("Găng tay gập Gym", "450000", R.drawable.product_2, "5");
        Product product3 = new Product("Tạ tay phòng tập Xinjuli", "65000", R.drawable.product_3, "5");
        productList.add(product);
        productList.add(product2);
        productList.add(product3);
        productsAdapter = new ProductsAdapter(getContext(), productList);
        rcvListHotProduct.setAdapter(productsAdapter);
        gridLayoutManager = new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false);
        gridLayoutManager.setAutoMeasureEnabled(true);
        rcvListHotProduct.setLayoutManager(gridLayoutManager);
        rcvListHotProduct.setHasFixedSize(true);
        rcvListHotProduct.setNestedScrollingEnabled(false);
        rcvListHotProduct.scheduleLayoutAnimation();
        productsAdapter.notifyDataSetChanged();
    }
}
