package com.example.supple_online.screen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.supple_online.R;

public class MatchProfileActivity extends AppCompatActivity {

    private TextView tvTitleMatchProfile;
    private TextView tvEditAddress;
    private TextView tvEditCharacter;
    private TextView tvEditSex;
    private TextView tvEditAge;
    private Button btnMatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_profile);
        initView();
        btnMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initView() {
        tvTitleMatchProfile = (TextView) findViewById(R.id.tvTitleMatchProfile);
        tvEditAddress = (TextView) findViewById(R.id.tvEditAddress);
        tvEditCharacter = (TextView) findViewById(R.id.tvEditCharacter);
        tvEditSex = (TextView) findViewById(R.id.tvEditSex);
        tvEditAge = (TextView) findViewById(R.id.tvEditAge);
        btnMatch = (Button) findViewById(R.id.btnMatch);
    }
}