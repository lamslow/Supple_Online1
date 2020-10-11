package com.example.supple_online.screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.supple_online.BaseActivity;
import com.example.supple_online.R;

import java.util.ArrayList;

public class PaymentActivity extends BaseActivity {

    private TextView tvFullNamePayment;
    private TextView tvAddressPayment;
    private TextView tvPhonePayment;
    private RecyclerView rvPayment;
    private EditText edtVoucherCode;
    private Button btnCheckVoucher;
    private LinearLayout linearLayout2;
    private TextView tvSumPricePayment;
    private Button btnOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        initView();

        btnCheckVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessegeSuccess("Chưa cập nhật");
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNewActivity(SuccessOrderActivity.class);
            }
        });

    }

    private void initView() {
        tvFullNamePayment = (TextView) findViewById(R.id.tvFullNamePayment);
        tvAddressPayment = (TextView) findViewById(R.id.tvAddressPayment);
        tvPhonePayment = (TextView) findViewById(R.id.tvPhonePayment);
        rvPayment = (RecyclerView) findViewById(R.id.rvPayment);
        edtVoucherCode = (EditText) findViewById(R.id.edtVoucherCode);
        btnCheckVoucher = (Button) findViewById(R.id.btnCheckVoucher);
        linearLayout2 = (LinearLayout) findViewById(R.id.linearLayout2);
        tvSumPricePayment = (TextView) findViewById(R.id.tvSumPricePayment);
        btnOrder = (Button) findViewById(R.id.btnOrder);
    }
}