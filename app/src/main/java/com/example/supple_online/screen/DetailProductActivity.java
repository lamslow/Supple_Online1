package com.example.supple_online.screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRatingBar;

import com.example.supple_online.R;
import com.example.supple_online.helper.BaseActivity;
import com.example.supple_online.helper.Config;

public class DetailProductActivity extends BaseActivity {

    private TextView tvTitleDetailProduct;
    private RelativeLayout rlBarProductDetail;
    private TextView tvSpecies;
    private ImageView imgProductDetail;
    private TextView tvNameProductDetail;
    private TextView tvPriceProductDetail;
    private TextView tvDescriptionDetail;
    private Button btnAddProduct;
    private AppCompatRatingBar ratingDetailProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        initView();
        Intent intent = getIntent();
        String nameProduct = intent.getStringExtra("nameProduct");
        int imageProduct = intent.getIntExtra("imageProduct", 0);
        String priceProduct = intent.getStringExtra("priceProduct");
        String votePointsProduct = intent.getStringExtra("votePointsProduct");
        tvTitleDetailProduct.setText(nameProduct);
        tvNameProductDetail.setText(nameProduct);
        imgProductDetail.setImageResource(imageProduct);
        tvPriceProductDetail.setText(Config.decimalFormat.format(Integer.parseInt(priceProduct)));
        ratingDetailProduct.setRating(Float.parseFloat(votePointsProduct));
        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessegeSuccess("Thêm vào giỏ hàng thành công");
            }
        });
    }

    private void initView() {
        tvTitleDetailProduct = (TextView) findViewById(R.id.tvTitleDetailProduct);
        rlBarProductDetail = (RelativeLayout) findViewById(R.id.rlBarProductDetail);
        tvSpecies = (TextView) findViewById(R.id.tvSpecies);
        imgProductDetail = (ImageView) findViewById(R.id.imgProductDetail);
        tvNameProductDetail = (TextView) findViewById(R.id.tvNameProductDetail);
        tvPriceProductDetail = (TextView) findViewById(R.id.tvPriceProductDetail);
        tvDescriptionDetail = (TextView) findViewById(R.id.tvDescriptionDetail);
        btnAddProduct = (Button) findViewById(R.id.btnAddProduct);
        ratingDetailProduct = (AppCompatRatingBar) findViewById(R.id.ratingDetailProduct);
    }
}