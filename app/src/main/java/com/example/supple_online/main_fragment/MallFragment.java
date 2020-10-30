package com.example.supple_online.main_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.supple_online.R;
import com.example.supple_online.adapter.PagerAdapter;
import com.example.supple_online.adapter.ProductsAdapter;
import com.example.supple_online.model.Product;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MallFragment extends Fragment {

    private Button btnMallSearch;
    private ImageButton btnMallCart;
    private TextView tvMallNumberInCart;
    private ViewFlipper vpFlipperImageMall;
    private GridLayoutManager gridLayoutManager;
    private RecyclerView rcvListHotProduct;
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
    }

    ProductsAdapter productsAdapter;
    List<Product> productList;
    private void getProduct() {
        productList = new ArrayList<>();
        productList.clear();
        Product product = new Product("100% Whey Gold Standard 5lbs (2.3kg)", "1450000", R.drawable.product_1, "5");
        Product product2 = new Product("Găng tay gập Gym", "450000", R.drawable.product_2,"5");
        Product product3 = new Product("Tạ tay phòng tập Xinjuli", "65000", R.drawable.product_3,"5");
        productList.add(product);
        productList.add(product2);
        productList.add(product3);
        productsAdapter = new ProductsAdapter(getContext(), productList);
        rcvListHotProduct.setAdapter(productsAdapter);
        gridLayoutManager = new GridLayoutManager(getContext(), 1,GridLayoutManager.HORIZONTAL, false);
        gridLayoutManager.setAutoMeasureEnabled(true);
        rcvListHotProduct.setLayoutManager(gridLayoutManager);
        rcvListHotProduct.setHasFixedSize(true);
        rcvListHotProduct.setNestedScrollingEnabled(false);
        rcvListHotProduct.scheduleLayoutAnimation();
        productsAdapter.notifyDataSetChanged();
    }
}
