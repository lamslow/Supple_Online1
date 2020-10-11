package com.example.supple_online.screen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.supple_online.BaseActivity;
import com.example.supple_online.R;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText edtUsername;
    private EditText edtPassword;
    private Button btnSignIn;
    private TextView tvForgotPass;
    private TextView tvDangKy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    public void initView() {
        tvForgotPass = findViewById(R.id.tvForgotPass);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        tvDangKy = findViewById(R.id.tvDangKy);
        btnSignIn = findViewById(R.id.btnSignIn);
        tvForgotPass.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
        tvDangKy.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == tvDangKy) {
            startNewActivity(SignUpActivity.class);
        } else if (view == btnSignIn){
            startNewActivity(HomeActivity.class);
        } else if(view == tvForgotPass) {
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
            View mView = View.inflate(this, R.layout.forget_password_item, null);
            mBuilder.setView(mView);
            mBuilder.setCancelable(true);
            final AlertDialog dialog = mBuilder.create();
            dialog.show();

            final EditText edtYourUsername;
            Button btnSaveNewPassword;
            Button btnCancelForgetPass;

            edtYourUsername = mView.findViewById(R.id.edtYourUsername);
            btnSaveNewPassword = mView.findViewById(R.id.btnSaveNewPassword);
            btnCancelForgetPass = mView.findViewById(R.id.btnCancelForgetPass);

            btnCancelForgetPass.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            btnSaveNewPassword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showMessegeSuccess("Cập nhật sau");
                }
            });
        }
    }
}