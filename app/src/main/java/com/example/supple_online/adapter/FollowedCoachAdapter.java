package com.example.supple_online.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.supple_online.R;
import com.example.supple_online.model.Coach;

import java.util.List;

public class FollowedCoachAdapter extends RecyclerView.Adapter<FollowedCoachAdapter.Holder> {
    private Context context;
    private List<Coach> coachList;

    public FollowedCoachAdapter(Context context, List<Coach> coachList) {
        this.context = context;
        this.coachList = coachList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_followed_coach, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.coach = coachList.get(position);
        holder.imvAvatarFollowedCoach.setImageResource(holder.coach.getImage());
        holder.tvDescriptionFollowedCoach.setText(holder.coach.getDescription());
        holder.tvNameFollowedCoach.setText(holder.coach.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return coachList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView imvAvatarFollowedCoach;
        private TextView tvNameFollowedCoach;
        private TextView tvDescriptionFollowedCoach;
        private Button btnInboxFollowedCoach;
        private ImageButton btnPhoneFollowedCoach;
        private Coach coach;

        public Holder(@NonNull View itemView) {
            super(itemView);
            imvAvatarFollowedCoach = (ImageView) itemView.findViewById(R.id.imvAvatarFollowedCoach);
            tvNameFollowedCoach = (TextView) itemView.findViewById(R.id.tvNameFollowedCoach);
            tvDescriptionFollowedCoach = (TextView) itemView.findViewById(R.id.tvDescriptionFollowedCoach);
            btnInboxFollowedCoach = (Button) itemView.findViewById(R.id.btnInboxFollowedCoach);
            btnPhoneFollowedCoach = (ImageButton) itemView.findViewById(R.id.btnPhoneFollowedCoach);
        }
    }
}
