package com.example.supple_online.screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.supple_online.R;
import com.example.supple_online.adapter.SliderAdapter;
import com.example.supple_online.helper.BaseActivity;

public class SliderActivity extends BaseActivity {

    ViewPager viewPager;
    private LinearLayout mDotsLayout;
    private SliderAdapter sliderAdapter;
    private Button btnSkip;
    private TextView[] mDots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        initView();
        viewPager.setAdapter(sliderAdapter);
        viewPager.addOnPageChangeListener(viewListener);
        addDot(0);
    }

    public void addDot(int position) {
        mDots = new TextView[3];
        mDotsLayout.removeAllViews();
        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorWhite));
            mDotsLayout.addView(mDots[i]);
        }

        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorDot));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {
        }
        @Override
        public void onPageSelected(int i) {
            addDot(i);
        }
        @Override
        public void onPageScrollStateChanged(int i) {
        }
    };

    private void initView() {
        btnSkip = findViewById(R.id.btnSkip);
        viewPager = findViewById(R.id.sliderViewPager);
        mDotsLayout = findViewById(R.id.dotsLayout);
        sliderAdapter = new SliderAdapter(this);
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startNewActivity(LoginActivity.class);
            }
        });
    }
}