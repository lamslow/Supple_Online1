package com.example.supple_online.main_fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.supple_online.R;
import com.example.supple_online.adapter.NotificationAdapter;
import com.example.supple_online.model.Notification;

import java.util.ArrayList;
import java.util.List;

public class NotificationFrament extends Fragment {

    private RecyclerView rcvListNotification;
    private GridLayoutManager gridLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        initView(view);
        getNotification();
        return view;
    }

    private void initView(View view) {
        rcvListNotification = (RecyclerView) view.findViewById(R.id.rcvListNotification);
    }

    private List<Notification> notificationList;
    private NotificationAdapter notificationAdapter;
    private void getNotification() {
        notificationList = new ArrayList<>();
        notificationList.clear();
        Notification notification = new Notification("Giảm giá - 50%", " Giảm giá 50% với toàn bộ mặt hàng thuộc danh mục thực phẩm hỗ trợ", "Ngày hết hạn: 12-11-2020");
        notificationList.add(notification);
        notificationAdapter = new NotificationAdapter(getContext(), notificationList);
        rcvListNotification.setAdapter(notificationAdapter);
        gridLayoutManager = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
        gridLayoutManager.setAutoMeasureEnabled(true);
        rcvListNotification.setLayoutManager(gridLayoutManager);
        rcvListNotification.setHasFixedSize(true);
        rcvListNotification.setNestedScrollingEnabled(false);
        rcvListNotification.scheduleLayoutAnimation();
        notificationAdapter.notifyDataSetChanged();
    }
}
