package com.example.supple_online.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.supple_online.R;
import com.example.supple_online.model.Coach;

import java.util.List;

public class CoachSuggestionsAdapter extends RecyclerView.Adapter<CoachSuggestionsAdapter.Holder> {

    private Context context;
    private List<Coach> coachesList;


    public CoachSuggestionsAdapter(Context context, List<Coach> coachesList) {
        this.context = context;
        this.coachesList = coachesList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coach_suggestions_home, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.coach = coachesList.get(position);
        holder.imvCoachesSuggestionHome.setImageResource(holder.coach.getImage());
        holder.tvNameCoachesSuggestionHome.setText(holder.coach.getName());
        holder.btnFollowCoachesBySuggestionHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return coachesList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private Coach coach;
        private ImageView imvCoachesSuggestionHome;
        private TextView tvNameCoachesSuggestionHome;
        private Button btnFollowCoachesBySuggestionHome;
        public Holder(@NonNull View itemView) {
            super(itemView);
            imvCoachesSuggestionHome = (ImageView) itemView.findViewById(R.id.imvCoachesSuggestionHome);
            tvNameCoachesSuggestionHome = (TextView) itemView.findViewById(R.id.tvNameCoachesSuggestionHome);
            btnFollowCoachesBySuggestionHome = (Button) itemView.findViewById(R.id.btnFollowCoachesBySuggestionHome);
        }
    }
}
