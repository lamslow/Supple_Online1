package com.example.supple_online.screen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.supple_online.R;
import com.example.supple_online.helper.BaseActivity;
import com.google.android.material.radiobutton.MaterialRadioButton;

public class AskCapacityActivity extends BaseActivity {

    private MaterialRadioButton btnRadioStudent;
    private MaterialRadioButton btnRadioCoach;
    private Button btnNextToAskAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_capacity);
        initView();
        btnNextToAskAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(SignUpActivity.class);
            }
        });

    }

    private void initView() {
        btnRadioStudent = (MaterialRadioButton) findViewById(R.id.btnRadioStudent);
        btnRadioCoach = (MaterialRadioButton) findViewById(R.id.btnRadioCoach);
        btnNextToAskAddress = (Button) findViewById(R.id.btnNextToAskAddress);
    }
}