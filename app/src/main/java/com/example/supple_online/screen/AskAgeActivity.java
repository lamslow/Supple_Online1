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

public class AskAgeActivity extends BaseActivity {

    private Spinner spnAge;
    private Button btnNextToAskCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_age);
        initView();
        getSpinnerAge();
        btnNextToAskCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(AskCharacterActivity.class);
            }
        });
    }

    private void initView() {
        spnAge = (Spinner) findViewById(R.id.spnAge);
        btnNextToAskCharacter = (Button) findViewById(R.id.btnNextToAskCharacter);
    }

    private void getSpinnerAge() {
        String arr[] = {"Dưới 20 tuổi","Từ 21 dến 30 tuổi","Từ 30 đến 40 tuổi","Trên 40 tuổi"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arr);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnAge.setAdapter(adapter);
        spnAge.setOnItemSelectedListener(new ProcessAgeSpinnerEvent());
    }

    private class ProcessAgeSpinnerEvent implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}