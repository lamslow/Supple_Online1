package com.example.supple_online.screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.supple_online.helper.BaseActivity;
import com.example.supple_online.R;
import com.example.supple_online.profile_fragment.MyOrderFragment;

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
                Intent intent = new Intent(SuccessOrderActivity.this, HomeActivity.class);
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