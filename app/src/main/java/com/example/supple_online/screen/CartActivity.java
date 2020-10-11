package com.example.supple_online.screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.supple_online.BaseActivity;
import com.example.supple_online.R;

public class CartActivity extends BaseActivity {

    private RecyclerView rvProductCart;
    private TextView tvSumPrice;
    private Button btnPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        initView();
        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNewActivity(PaymentActivity.class);
            }
        });
    }

    private void initView() {
        rvProductCart = (RecyclerView) findViewById(R.id.rvProductCart);
        tvSumPrice = (TextView) findViewById(R.id.tvSumPrice);
        btnPayment = (Button) findViewById(R.id.btnPayment);
    }
}