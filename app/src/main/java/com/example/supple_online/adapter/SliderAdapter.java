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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.supple_online.R;
import com.example.supple_online.screen.LoginActivity;

public class SliderAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    private int[] slider_images = {
            R.drawable.color,
            R.drawable.deliverytruck,
            R.drawable.pay,
    };

    private String[] slider_headings = {
            "ĐA DẠNG SẢN PHẨM",
            "GIAO HÀNG NHANH CHÓNG",
            "ĐẶT HÀNG DỄ DÀNG"
    };

    private String[] slider_des = {
            "Supple Online cung cấp cho người dùng không chỉ đầy đủ các loại thực phẩm chức năng mới nhất mà còn đảm bảo chất lượng luôn đi đầu so với thị trường.",
            "Supple Online hiện đang liên kết với những đối tác vận chuyển lớn nhất toàn quốc giúp cho việc giao hàng diễn ra rất nhanh chóng",
            "Với Supple Online bạn chỉ cần thêm hàng vào giỏ và có thể thanh toán dễ dàng tại bất cứ đâu, bất cứ lúc nào mà bạn mong muốn."
    };

    @Override
    public int getCount() {
        return slider_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout, container, false);

        ImageView sliderImageView = view.findViewById(R.id.imgSlider);
        TextView tvHeading = view.findViewById(R.id.tvHeading);
        TextView tvDes = view.findViewById(R.id.tvDescription);
        Button btnDiscover = view.findViewById(R.id.btnSlider);

        btnDiscover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LoginActivity.class);
                context.startActivity(intent);
            }
        });

        sliderImageView.setImageResource(slider_images[position]);
        tvHeading.setText(slider_headings[position]);
        tvDes.setText(slider_des[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
