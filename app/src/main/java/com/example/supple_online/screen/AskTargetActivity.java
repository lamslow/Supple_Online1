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

public class AskTargetActivity extends BaseActivity {

    private Spinner spnTarget;
    private Button btnNextToAskAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_target);
        initView();
        getSpinnerTarget();
        btnNextToAskAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(AskAgeActivity.class);
            }
        });
    }

    private void initView() {
        spnTarget = (Spinner) findViewById(R.id.spnTarget);
        btnNextToAskAge = (Button) findViewById(R.id.btnNextToAskAge);
    }

    private void getSpinnerTarget() {
        String arr[] = {"Giảm cân", "Tăng cân", "Thể hình đẹp", "Dẻo dai", "Khỏe mạnh"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arr);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnTarget.setAdapter(adapter);
        spnTarget.setOnItemSelectedListener(new ProcessTargetSpinnerEvent());
    }

    private class ProcessTargetSpinnerEvent implements android.widget.AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}