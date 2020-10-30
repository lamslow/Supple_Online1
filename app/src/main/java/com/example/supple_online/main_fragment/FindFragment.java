package com.example.supple_online.main_fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.supple_online.R;
import com.example.supple_online.adapter.CoachesAdapter;
import com.example.supple_online.model.Coach;

import java.util.ArrayList;
import java.util.List;

public class FindFragment extends Fragment {
    private Button btnSearch;
    private RecyclerView rcvListCoachInFind;
    private GridLayoutManager gridLayoutManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        initView(view);
        getCoachList();
        return view;
    }

    private void initView(View view) {
        btnSearch = (Button) view.findViewById(R.id.btnSearch);
        rcvListCoachInFind = (RecyclerView) view.findViewById(R.id.rcvListCoachInFind);
    }

    private List<Coach> coachList;
    private CoachesAdapter coachesAdapter;
    private void getCoachList() {
        coachList = new ArrayList<>();
        coachList.clear();
        Coach coach = new Coach("Monu - Gym Instructor", R.drawable.coach_1, "Huấn luyện viên Gym", "4", "75");
        Coach coach2 = new Coach("Hoàng Hiển - Personal Trainer", R.drawable.coach_2, "Huấn luyện viên Bơi", "5", "100");
        Coach coach3 = new Coach("Walter Veale FitNation", R.drawable.coach_3, "Huấn luyện viên Kick Boxing", "5", "75");
        coachList.add(coach);
        coachList.add(coach2);
        coachList.add(coach3);
        coachesAdapter = new CoachesAdapter(getContext(), coachList);
        rcvListCoachInFind.setAdapter(coachesAdapter);
        gridLayoutManager = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
        gridLayoutManager.setAutoMeasureEnabled(true);
        rcvListCoachInFind.setLayoutManager(gridLayoutManager);
        rcvListCoachInFind.setHasFixedSize(true);
        rcvListCoachInFind.setNestedScrollingEnabled(false);
        rcvListCoachInFind.scheduleLayoutAnimation();
        coachesAdapter.notifyDataSetChanged();
    }
}
