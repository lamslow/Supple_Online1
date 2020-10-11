package com.example.supple_online.main_fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.supple_online.R;
import com.example.supple_online.screen.MyOrderActivity;

import es.dmoral.toasty.Toasty;

public class ProfileFragment extends Fragment {

    private TextView tvFullName;
    private TextView tvPhoneNumber;
    private Button btnEditProfile;
    private LinearLayout llMyOrders;
    private LinearLayout llChangePass;
    private LinearLayout llShareFacebook;
    private LinearLayout llMyVoucher;
    private LinearLayout llSignOut;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        initView(view);
        llMyOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MyOrderActivity.class);
                startActivity(intent);
            }
        });

        llChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder1 = new AlertDialog.Builder(getContext());
                View mView1 = View.inflate(getContext(), R.layout.change_password_item, null);
                mBuilder1.setView(mView1);
                final AlertDialog dialog1 = mBuilder1.create();
                dialog1.show();

                final EditText edtCurrentPass;
                final EditText edtNewPass;
                final EditText edtReNewPass;
                final Button btnSaveNewPass;
                final Button btnCancelChangePass;
                final EditText edtEmail;

                edtEmail = (EditText) mView1.findViewById(R.id.edtEmail);
                edtCurrentPass = mView1.findViewById(R.id.edtCurrentPass);
                edtNewPass = mView1.findViewById(R.id.edtNewPass);
                edtReNewPass = mView1.findViewById(R.id.edtReNewPass);
                btnSaveNewPass = mView1.findViewById(R.id.btnSaveNewPass);
                btnCancelChangePass = mView1.findViewById(R.id.btnCancelChangePass);

                btnCancelChangePass.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog1.dismiss();
                    }
                });

                btnSaveNewPass.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtCurrentPass.setText("");
                        edtNewPass.setText("");
                        edtReNewPass.setText("");
                        Toasty.success(getContext(), "Chưa cập nhật", Toast.LENGTH_SHORT).show();
                        dialog1.dismiss();
                    }
                });
            }
        });
        return view;
    }

    public void initView(View view) {
        tvFullName = (TextView) view.findViewById(R.id.tvFullName);
        tvPhoneNumber = (TextView) view.findViewById(R.id.tvPhoneNumber);
        btnEditProfile = (Button) view.findViewById(R.id.btnEditProfile);
        llMyOrders = (LinearLayout) view.findViewById(R.id.llMyOrders);
        llChangePass = (LinearLayout) view.findViewById(R.id.llChangePass);
        llShareFacebook = (LinearLayout) view.findViewById(R.id.llShareFacebook);
        llMyVoucher = (LinearLayout) view.findViewById(R.id.llMyVoucher);
        llSignOut = (LinearLayout) view.findViewById(R.id.llSignOut);
    }

}
