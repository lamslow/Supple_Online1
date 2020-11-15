package com.example.supple_online.screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.supple_online.helper.BaseActivity;
import com.example.supple_online.R;

public class SuccessOrderActivity extends BaseActivity {

    Button btnMyOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_order);
        initView();
        btnMyOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SuccessOrderActivity.this, HomeUserActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        return;
    }

    private void initView() {
        btnMyOrders = (Button) findViewById(R.id.btnMyOrders);
    }
}