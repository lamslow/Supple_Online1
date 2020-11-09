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

public class AskCharacterActivity extends BaseActivity {

    private Spinner spnCharacter;
    private Button btnNextToSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_character);
        initView();
        getSpinnerCharacter();
        btnNextToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(SignUpActivity.class);
            }
        });
    }

    private void initView() {
        spnCharacter = (Spinner) findViewById(R.id.spnCharacter);
        btnNextToSignUp = (Button) findViewById(R.id.btnNextToSignUp);
    }

    private void getSpinnerCharacter() {
        String arr[] = {"Kỷ luật", "Vui vẻ", "Cẩn thận", "Linh hoạt", "Hiếu kỳ"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arr);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnCharacter.setAdapter(adapter);
        spnCharacter.setOnItemSelectedListener(new ProcessCharacterSpinnerEvent());
    }

    private class ProcessCharacterSpinnerEvent implements android.widget.AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}