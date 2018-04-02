package com.willpower.study.home;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.willpower.study.R;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView mRecycler;
    FrameLayout startLayout;
    ImageView startImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        if (startLayout.getVisibility() == View.VISIBLE) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    AnimatorSet animatorSet = new AnimatorSet();
                    ObjectAnimator animator1 = ObjectAnimator.ofFloat(startLayout, "Alpha", 1f, 0f);
                    animator1.setDuration(1000);
                    ObjectAnimator animator2 = ObjectAnimator.ofFloat(startImage, "ScaleX", 1f, 0f);
                    animator2.setDuration(800);
                    ObjectAnimator animator3 = ObjectAnimator.ofFloat(startImage, "ScaleY", 1f, 0f);
                    animator3.setDuration(800);
                    animatorSet.playTogether(animator1, animator2, animator3);
                    animatorSet.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            startLayout.setVisibility(View.GONE);
                        }
                    });
                    animatorSet.start();
                }
            }, 1000);
        }
    }

    private void init() {
        startLayout = (FrameLayout) findViewById(R.id.startLayout);
        startImage = (ImageView) findViewById(R.id.startImage);
        mRecycler = (RecyclerView) findViewById(R.id.mList);
        HomeAdapter adapter = new HomeAdapter(getData(), this);
        mRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        mRecycler.setAdapter(adapter);
    }

    private List<ChapterBean> getData() {
        List<ChapterBean> data = new ArrayList<>();
        data.add(new ChapterBean("第一章", "Activity的生命周期和启动模式"));
        data.add(new ChapterBean("第二章", "Activity的生命周期和启动模式"));
        data.add(new ChapterBean("第三章", "Activity的生命周期和启动模式"));
        data.add(new ChapterBean("第四章", "Activity的生命周期和启动模式"));
        data.add(new ChapterBean("第五章", "Activity的生命周期和启动模式"));
        data.add(new ChapterBean("第六章", "Activity的生命周期和启动模式"));
        data.add(new ChapterBean("第七章", "Android动画深入分析"));
        data.add(new ChapterBean("第八章", "Activity的生命周期和启动模式"));
        data.add(new ChapterBean("第九章", "Activity的生命周期和启动模式"));
        data.add(new ChapterBean("第十章", "Activity的生命周期和启动模式"));
        data.add(new ChapterBean("第十一章", "Activity的生命周期和启动模式"));
        data.add(new ChapterBean("第十二章", "Activity的生命周期和启动模式"));
        data.add(new ChapterBean("第十三章", "Activity的生命周期和启动模式"));
        data.add(new ChapterBean("第十四章", "Activity的生命周期和启动模式"));
        data.add(new ChapterBean("第十五章", "Activity的生命周期和启动模式"));
        return data;
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(false);
    }
}
