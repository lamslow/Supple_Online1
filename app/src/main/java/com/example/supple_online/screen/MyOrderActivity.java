package com.example.supple_online.screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.supple_online.R;

public class MyOrderActivity extends AppCompatActivity {

    private RecyclerView rvMyOrders;
    private ImageView imvHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        initView();
        imvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyOrderActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView(){
        rvMyOrders = (RecyclerView) findViewById(R.id.rvMyOrders);
        imvHome = (ImageView) findViewById(R.id.imvHome);
    }
}