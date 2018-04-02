package com.willpower.study.chapter7;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.willpower.study.R;
import com.willpower.study.home.ChapterBean;
import com.willpower.study.home.HomeAdapter;
import com.willpower.study.util.ToolbarHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/2.
 * View动画的特殊场景:
 * (一)LayoutAnimation
 * 1.LayoutAnimation:作用于ViewGroup，主要适用于ListView,RecyclerView.
 * 使用方法（一）静态生成
 * ①定义LayoutAnimation(res/anim/filename.xml):
 * 主要属性--
 * android：delay(表示动画延迟时间，例android：delay= 150ms,那第一个item延迟150ms后开始，第二个延迟300ms...);
 * android:animationOrder(表示子元素动画顺序，三种选项：normal{顺序显示}，reverse{逆向显示}，random{随机显示});
 * android:animation(为子元素制定具体的入场动画)
 * ②为子元素指定具体的入场动画（View动画）
 * ③为viewGroup指定android：layoutAnimation属性
 * 使用方法（二）动态生成
 * ① Animation animation = AnimationUtils.loadAnimation(context,resId);
 * LayoutAnimationController controller = new LayoutAnimationController(animation);
 * controller.setDelay(0.5f);//注：当delay小于1.0f或者100%时动画重叠
 * controller。setOrder(LayoutAnimationController.ORDER_NORMAL);
 * viewGroup.setLayoutAnimation(controller);
 * (一)Activity转场动画
 * overridePendingTransition(enterAnim,exitAnim);//进入动画，退出动画
 * 注：overridePendingTransition必须在startActivity(intent)后，或者activity.finish()后调用
 */

public class Chapter7_2Activity extends AppCompatActivity {
    RecyclerView mList;

    HomeAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter7_1_2_activity);
        ToolbarHelper.initBack(this);
        mList = (RecyclerView) findViewById(R.id.mList);
        adapter = new HomeAdapter(getData(), this);
        mList.setLayoutManager(new GridLayoutManager(this, 2));
        mList.setAdapter(adapter);
    }

    private List<ChapterBean> getData() {
        List<ChapterBean> data = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            data.add(new ChapterBean("LayoutAnimation", "Item" + i));
        }
        return data;
    }
}
