package com.willpower.study.chapter7;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.willpower.study.R;
import com.willpower.study.util.ToolbarHelper;

/**
 * Created by Administrator on 2018/4/2.
 * 帧动画：
 * 帧动画也属于View动画，它是顺序播放一组预先定义好的图片，类似与电影播放。不同于View动画，
 * 系统提供了另外一个类AnimationDrawable来使用帧动画。
 * 注意：帧动画使用比较简单但是容易OOM，在使用帧动画时注意避免使用尺寸过大的图片。
 */

public class Chapter7_3Activity extends AppCompatActivity {

    ImageView frameImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter7_2_activity);
        ToolbarHelper.initBack(this);
        frameImageView = (ImageView) findViewById(R.id.frameImageView);
        AnimationDrawable animationDrawable = (AnimationDrawable) frameImageView.getDrawable();
        animationDrawable.start();
    }
}
