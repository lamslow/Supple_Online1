package com.example.supple_online.screen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.supple_online.R;
import com.example.supple_online.helper.BaseActivity;

public class PaymentActivity extends BaseActivity {


    private TextView tvFullNamePayment;
    private TextView tvAddressPayment;
    private TextView tvPhonePayment;
    private RecyclerView rvPayment;
    private LinearLayout linearLayout2;
    private TextView tvSumPrice;
    private Button btnPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        initView();
        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(SuccessOrderActivity.class);
            }
        });
    }


    private void initView() {
        tvFullNamePayment = (TextView) findViewById(R.id.tvFullNamePayment);
        tvAddressPayment = (TextView) findViewById(R.id.tvAddressPayment);
        tvPhonePayment = (TextView) findViewById(R.id.tvPhonePayment);
        rvPayment = (RecyclerView) findViewById(R.id.rvPayment);
        linearLayout2 = (LinearLayout) findViewById(R.id.linearLayout2);
        tvSumPrice = (TextView) findViewById(R.id.tvSumPrice);
        btnPayment = (Button) findViewById(R.id.btnPayment);
    }
}