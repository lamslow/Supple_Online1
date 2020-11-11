package com.example.supple_online.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.supple_online.R;
import com.example.supple_online.helper.Config;
import com.example.supple_online.model.Product;
import com.example.supple_online.screen.DetailProductActivity;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.Holder> {

    private Context context;
    private List<Product> productList;

    public ProductsAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hot_product_mall, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int position) {
        holder.product = productList.get(position);
        holder.imvImageNew.setImageResource(holder.product.getImage());
        holder.tvTitleNew.setText(holder.product.getName());
        holder.tvPriceProduct.setText(Config.decimalFormat.format(Integer.parseInt(holder.product.getPrice())) + " Đ");
        holder.ratingProductMall.setRating(Float.parseFloat(holder.product.getVote()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailProductActivity.class);
                intent.putExtra("imageProduct", holder.product.getImage());
                intent.putExtra("nameProduct", holder.product.getName());
                intent.putExtra("priceProduct", holder.product.getPrice());
                intent.putExtra("votePointsProduct", holder.product.getVote());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView imvImageNew;
        private TextView tvTitleNew;
        private RatingBar ratingProductMall;
        private Product product;
        private TextView tvPriceProduct;

        public Holder(@NonNull View itemView) {
            super(itemView);
            imvImageNew = (ImageView) itemView.findViewById(R.id.imvImageNew);
            tvTitleNew = (TextView) itemView.findViewById(R.id.tvTitleNew);
            ratingProductMall = (RatingBar) itemView.findViewById(R.id.ratingProductMall);
            tvPriceProduct = (TextView) itemView.findViewById(R.id.tvPriceProduct);
        }
    }
}
