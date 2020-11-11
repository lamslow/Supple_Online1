package com.example.supple_online.inbox_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.supple_online.R;
import com.example.supple_online.adapter.FollowedCoachAdapter;
import com.example.supple_online.main_fragment.HomeFragment;
import com.example.supple_online.model.Coach;

import java.util.ArrayList;
import java.util.List;

public class FollowedCoachFragment extends Fragment {

    private RelativeLayout rlBarMallProduct;
    private ImageView imvBackInFollowedCoachFragment;
    private RecyclerView rcvListFollowedCoach;
    private GridLayoutManager gridLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_followed_coach, container, false);
        initView(view);
        getFollowedCoach();

        imvBackInFollowedCoachFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragment homeFragment = new HomeFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, homeFragment, "backToHomeFragment")
                        .addToBackStack(null).commit();
            }
        });

        return view;
    }

    private void initView(View view) {
        rlBarMallProduct = (RelativeLayout) view.findViewById(R.id.rlBarMallProduct);
        imvBackInFollowedCoachFragment = (ImageView) view.findViewById(R.id.imvBackInFollowedCoachFragment);
        rcvListFollowedCoach = (RecyclerView) view.findViewById(R.id.rcvListFollowedCoach);
    }

    FollowedCoachAdapter followedCoachAdapter;
    List<Coach> coachList;
    private void getFollowedCoach() {
        coachList = new ArrayList<>();
        coachList.clear();
        Coach coach = new Coach("Monu - Gym Instructor", R.drawable.coach_1, "Huấn luyện viên Gym", "4", "75");
        coachList.add(coach);
        followedCoachAdapter = new FollowedCoachAdapter(getContext(), coachList);
        rcvListFollowedCoach.setAdapter(followedCoachAdapter);
        gridLayoutManager = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
        gridLayoutManager.setAutoMeasureEnabled(true);
        rcvListFollowedCoach.setLayoutManager(gridLayoutManager);
        rcvListFollowedCoach.setHasFixedSize(true);
        rcvListFollowedCoach.setNestedScrollingEnabled(false);
        rcvListFollowedCoach.scheduleLayoutAnimation();
        followedCoachAdapter.notifyDataSetChanged();
    }
}