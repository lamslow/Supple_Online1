package com.example.supple_online.screen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.supple_online.BaseActivity;
import com.example.supple_online.R;

public class SignUpActivity extends BaseActivity {

    private EditText edtSUUsername;
    private EditText edtSUFullName;
    private EditText edtSUAddress;
    private EditText edtSUPhone;
    private EditText edtSUPassword;
    private EditText edtSURepassword;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initView();
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessegeSuccess("Cập nhật sau");
                clearAllEdt();
            }
        });
    }

    private void initView() {
        edtSUUsername = (EditText) findViewById(R.id.edtSU_Username);
        edtSUFullName = (EditText) findViewById(R.id.edtSU_FullName);
        edtSUAddress = (EditText) findViewById(R.id.edtSU_Address);
        edtSUPhone = (EditText) findViewById(R.id.edtSU_Phone);
        edtSUPassword = (EditText) findViewById(R.id.edtSU_Password);
        edtSURepassword = (EditText) findViewById(R.id.edtSU_Repassword);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
    }

    private void clearAllEdt() {
        edtSUUsername.setText("");
        edtSURepassword.setText("");
        edtSUPassword.setText("");
        edtSUFullName.setText("");
        edtSUPhone.setText("");
        edtSUAddress.setText("");
    }
}