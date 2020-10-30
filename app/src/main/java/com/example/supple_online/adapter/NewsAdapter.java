package com.example.supple_online.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.supple_online.R;
import com.example.supple_online.model.New;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.Holder> {

    private Context context;
    private List<New> newsList;


    public NewsAdapter(Context context, List<New> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_newest_news_home, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.news = newsList.get(position);
        holder.mImvImageNew.setImageResource(holder.news.getImage());
        holder.mTvTitleNew.setText(holder.news.getTitle());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView mImvImageNew;
        private TextView mTvTitleNew;
        private New news;
        public Holder(@NonNull View itemView) {
            super(itemView);
            mImvImageNew = itemView.findViewById(R.id.imvImageNew);
            mTvTitleNew = itemView.findViewById(R.id.tvTitleNew);
        }
    }
}
