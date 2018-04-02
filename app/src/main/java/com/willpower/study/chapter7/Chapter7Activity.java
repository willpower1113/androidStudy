package com.willpower.study.chapter7;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.willpower.study.R;
import com.willpower.study.chapter7.adapter.Chapter7RecyclerAdapter;
import com.willpower.study.home.ChapterBean;
import com.willpower.study.util.ToolbarHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/30.
 */

public class Chapter7Activity extends AppCompatActivity {
    RecyclerView mRecycler;
    Chapter7RecyclerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter7_activity);
        ToolbarHelper.initBack(this);
        ToolbarHelper.initTitle(this, "第七章 Android动画深入分析");
        initRecycler();
    }

    void initRecycler() {
        mRecycler = (RecyclerView) findViewById(R.id.recycler_chapter7_activity);
        mRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new Chapter7RecyclerAdapter(this, getData());
        mRecycler.setAdapter(adapter);
    }

    List<ChapterBean> getData() {
        List<ChapterBean> mData = new ArrayList<>();
        mData.add(new ChapterBean("序言", ""));
        mData.add(new ChapterBean("第一节", "View动画"));
        mData.add(new ChapterBean("第二节", "View动画的场景应用"));
        mData.add(new ChapterBean("第三节", "帧动画"));
        mData.add(new ChapterBean("第四节", "属性动画（一）"));
        mData.add(new ChapterBean("第五节", "属性动画（二）"));
        mData.add(new ChapterBean("第六节", "属性动画（三）"));
        mData.add(new ChapterBean("第七节", "svg动画"));
        mData.add(new ChapterBean("第八节", "自定义动画"));
        return mData;
    }
}
