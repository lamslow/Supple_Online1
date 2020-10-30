package com.example.supple_online.main_fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.supple_online.R;
import com.example.supple_online.adapter.CoachSuggestionsAdapter;
import com.example.supple_online.adapter.LessonsAdapter;
import com.example.supple_online.adapter.NewsAdapter;
import com.example.supple_online.adapter.SliderHomeAdapter;
import com.example.supple_online.model.Coach;
import com.example.supple_online.model.ImageSlider;
import com.example.supple_online.model.Lesson;
import com.example.supple_online.model.New;
import com.example.supple_online.screen.CartActivity;
import com.example.supple_online.screen.SearchActivity;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private ViewFlipper viewFlipper;
    private Button btnSearch;
    private ImageButton btnCart;
    private TextView tvNumberInCart;
    private RecyclerView rcvListNewsHome, rcvListLessonsHome, rcvListSuggestionCoachHome;
    private GridLayoutManager gridLayoutManager;
    private NestedScrollView scrollView_home;
    private LinearLayout llHeader;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        getNewsHome();
        getLessonsHome();
        getImageSliderHome();
        getCoachSuggestionHome();
        int images[] = {R.drawable.banner1, R.drawable.banner2, R.drawable.banner3};
        for (int image : images) {
            flipperImages(image);
        }

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CartActivity.class);
                startActivity(intent);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });

//        scrollView_home.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
//            @Override
//            public void onScrollChanged() {
//                if (scrollView_home != null) {
//                    if (scrollView_home.getChildAt(0).getBottom() <= (scrollView_home.getHeight() + scrollView_home.getScrollY())) {
//                        llHeader.setVisibility(View.VISIBLE);
//                    } else {
//                        llHeader.setVisibility(View.INVISIBLE);
//                    }
//                }
//            }
//        });

        return view;
    }

    private void flipperImages(int image) {
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(image);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(2500);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(getContext(), android.R.anim.fade_in);
    }


    private void initView(View view) {
        btnSearch = (Button) view.findViewById(R.id.btnSearch);
        btnCart = (ImageButton) view.findViewById(R.id.btnCart);
        tvNumberInCart = (TextView) view.findViewById(R.id.tvNumberInCart);
        viewFlipper = (ViewFlipper) view.findViewById(R.id.vpSlider);
        rcvListNewsHome = (RecyclerView) view.findViewById(R.id.rcvListNewsHome);
        rcvListLessonsHome = (RecyclerView) view.findViewById(R.id.rcvListLessonsHome);
        scrollView_home = (NestedScrollView) view.findViewById(R.id.scrollView_home);
        llHeader = (LinearLayout) view.findViewById(R.id.llHeader);
        sliderView = (SliderView) view.findViewById(R.id.imageSlider);
        rcvListSuggestionCoachHome = (RecyclerView) view.findViewById(R.id.rcvListSuggestionCoachHome);
    }


    private NewsAdapter newsAdapter;
    private List<New> newsList;

    private void getNewsHome() {
        newsList = new ArrayList<>();
        newsList.clear();
        New news = new New(R.drawable.newest_news_gymroom, "Top 10 phòng tập tốt nhất khu vực Hải Phòng");
        New news2 = new New(R.drawable.newest_news_gymevent, "Sự kiện 'Vì một gia đình khỏe mạnh' được tổ chức tại Hà Nội");
        New news3 = new New(R.drawable.newest_news_stomachache, "Nguyên nhân dẫn đến cơn đau bụng mỗi đêm");
        New news4 = new New(R.drawable.newest_news_tired, "Những cách giúp bạn giảm bớt căng thẳng sau giờ làm việc");
        newsList.add(news);
        newsList.add(news2);
        newsList.add(news3);
        newsList.add(news4);
        newsAdapter = new NewsAdapter(getContext(), newsList);
        gridLayoutManager = new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false);
        rcvListNewsHome.setAdapter(newsAdapter);
        gridLayoutManager.setAutoMeasureEnabled(true);
        rcvListNewsHome.setLayoutManager(gridLayoutManager);
        rcvListNewsHome.setHasFixedSize(true);
        rcvListNewsHome.setNestedScrollingEnabled(false);
        rcvListNewsHome.scheduleLayoutAnimation();
        newsAdapter.notifyDataSetChanged();
    }

    private LessonsAdapter lessonsAdapter;
    private List<Lesson> lessonsList;

    private void getLessonsHome() {
        lessonsList = new ArrayList<>();
        lessonsList.clear();
        Lesson lessons = new Lesson("XAxycuZPxQE", "BÀI TẬP MÔNG QUẢ ĐÀO | KHẮC PHỤC MÔNG HÓP | 30 phút HIP DIP", R.drawable.lesson_1_home);
        Lesson lessons2 = new Lesson("fKhpHe-Mo9I&t", "Bốn LÝ DO khiến bạn TẬP NGỰC mãi không lên & GIẢI PHÁP", R.drawable.lesson_2_home);
        Lesson lessons3 = new Lesson("ehpFsiDIbuc", "15 sai lầm phổ biến trong việc tập luyện bạn cần từ bỏ", R.drawable.lesson_4_home);
        Lesson lessons4 = new Lesson("mra27LEwpS8", "Cách để Đốt nhiều Mỡ Hơn Khi Ngủ", R.drawable.lesson_3_home);
        lessonsList.add(lessons);
        lessonsList.add(lessons2);
        lessonsList.add(lessons3);
        lessonsList.add(lessons4);
        lessonsAdapter = new LessonsAdapter(getContext(), lessonsList);
        rcvListLessonsHome.setAdapter(lessonsAdapter);
        gridLayoutManager = new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false);
        gridLayoutManager.setAutoMeasureEnabled(true);
        rcvListLessonsHome.setLayoutManager(gridLayoutManager);
        rcvListLessonsHome.setHasFixedSize(true);
        rcvListLessonsHome.setNestedScrollingEnabled(false);
        rcvListLessonsHome.scheduleLayoutAnimation();
        lessonsAdapter.notifyDataSetChanged();
    }

    private SliderView sliderView;
    List<ImageSlider> imageSliderList;
    private void getImageSliderHome() {
        ImageSlider imageSlider = new ImageSlider(R.drawable.banner_slide_1);
        ImageSlider imageSlider2 = new ImageSlider(R.drawable.banner_slide_2);
        ImageSlider imageSlider3 = new ImageSlider(R.drawable.banner_slide_3);
        imageSliderList = new ArrayList<>();
        imageSliderList.clear();
        imageSliderList.add(imageSlider2);
        imageSliderList.add(imageSlider);
        imageSliderList.add(imageSlider3);
        sliderView.setSliderAdapter(new SliderHomeAdapter(getContext(), imageSliderList));
        sliderView.setIndicatorAnimation(IndicatorAnimationType.THIN_WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(3); //set scroll delay in seconds :
        sliderView.startAutoCycle();
    }

    private List<Coach> coachList;
    private CoachSuggestionsAdapter coachesAdapter;
    private void getCoachSuggestionHome() {
        coachList = new ArrayList<>();
        coachList.clear();
        Coach coach = new Coach("Monu - Gym Instructor", R.drawable.coach_1, "Huấn luyện viên Gym", "4", "75");
        Coach coach2 = new Coach("Hoàng Hiển - Personal Trainer", R.drawable.coach_2, "Huấn luyện viên Bơi", "5", "100");
        Coach coach3 = new Coach("Walter Veale FitNation", R.drawable.coach_3, "Huấn luyện viên Kick Boxing", "5", "75");
        coachList.add(coach2);
        coachList.add(coach);
        coachList.add(coach3);
        coachesAdapter = new CoachSuggestionsAdapter(getContext(), coachList);
        rcvListSuggestionCoachHome.setAdapter(coachesAdapter);
        gridLayoutManager = new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false);
        gridLayoutManager.setAutoMeasureEnabled(true);
        rcvListSuggestionCoachHome.setLayoutManager(gridLayoutManager);
        rcvListSuggestionCoachHome.setHasFixedSize(true);
        rcvListSuggestionCoachHome.setNestedScrollingEnabled(false);
        rcvListSuggestionCoachHome.scheduleLayoutAnimation();
        coachesAdapter.notifyDataSetChanged();
    }

}
