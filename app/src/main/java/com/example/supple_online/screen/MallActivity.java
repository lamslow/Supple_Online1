package com.example.supple_online.screen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.supple_online.R;
import com.example.supple_online.main_fragment.MallFragment;

public class MallActivity extends AppCompatActivity {
    private FrameLayout fragmentMall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall);
        fragmentMall = (FrameLayout) findViewById(R.id.fragment_mall);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_mall, new MallFragment()).commit();
    }
}