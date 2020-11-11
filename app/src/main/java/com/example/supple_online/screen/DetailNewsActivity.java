package com.example.supple_online.screen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.supple_online.R;

public class DetailNewsActivity extends AppCompatActivity {

    private TextView tvTitleNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);
        initView();
        Intent intent = getIntent();
        tvTitleNews.setText(intent.getStringExtra("titleNews"));
        tvTitleNews.setSelected(true);
    }

    private void initView() {
        tvTitleNews = (TextView) findViewById(R.id.tvTitleNews);
    }
}