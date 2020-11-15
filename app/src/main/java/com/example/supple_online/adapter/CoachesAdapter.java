package com.example.supple_online.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.recyclerview.widget.RecyclerView;
import com.example.supple_online.R;
import com.example.supple_online.model.Coach;
import com.example.supple_online.screen.DetailCoachActivity;

import java.util.List;

public class CoachesAdapter extends RecyclerView.Adapter<CoachesAdapter.Holder> {

    private Context context;
    private List<Coach> coachList;

    public CoachesAdapter(Context context, List<Coach> coachList) {
        this.context = context;
        this.coachList = coachList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coach, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.coach = coachList.get(position);
        holder.imvAvatarCoach.setImageResource(holder.coach.getImage());
        holder.tvNameCoach.setText(holder.coach.getName());
        holder.tvDescriptionCoach.setText(holder.coach.getDescription());
        holder.tvRelevanceRate.setText("PT - iMatch: " + holder.coach.getRelevanceRate()+ "%");
        holder.ratingCoach.setRating(Float.parseFloat(holder.coach.getRatePoint()));
        holder.btnFollowCoachesBySuggestionHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailCoachActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return coachList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private ImageView imvAvatarCoach;
        private Button btnFollowCoachesBySuggestionHome;
        private TextView tvNameCoach;
        private TextView tvDescriptionCoach;
        private AppCompatRatingBar ratingCoach;
        private TextView tvRelevanceRate;
        private Coach coach;

        public Holder(@NonNull View itemView) {
            super(itemView);
            imvAvatarCoach = (ImageView) itemView.findViewById(R.id.imvAvatarCoach);
            btnFollowCoachesBySuggestionHome = (Button) itemView.findViewById(R.id.btnFollowCoachesBySuggestionHome);
            tvNameCoach = (TextView) itemView.findViewById(R.id.tvNameCoach);
            tvDescriptionCoach = (TextView) itemView.findViewById(R.id.tvDescriptionCoach);
            ratingCoach = (AppCompatRatingBar) itemView.findViewById(R.id.ratingCoach);
            tvRelevanceRate = (TextView) itemView.findViewById(R.id.tvRelevanceRate);
        }
    }
}
