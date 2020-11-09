package com.example.supple_online.screen;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.supple_online.R;
import com.example.supple_online.helper.BaseActivity;

public class AskAddressActivity extends BaseActivity {

    private Spinner spnAddress;
    private Button btnNextToAskTarget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_address);
        initView();
        getSpinner();
        btnNextToAskTarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(AskTargetActivity.class);
            }
        });
    }

    private void initView() {
        spnAddress = (Spinner) findViewById(R.id.spnAddress);
        btnNextToAskTarget = (Button) findViewById(R.id.btnNextToAskTarget);
    }

    private void getSpinner() {
        String arr[] = {"Hà Nội", "Hồ Chí Minh", "Cần Thơ", "Đà Nẵng", "Hải Phòng"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arr);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnAddress.setAdapter(adapter);
        spnAddress.setOnItemSelectedListener(new ProcessAddressSpinnerEvent());
    }

    private class ProcessAddressSpinnerEvent implements android.widget.AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}