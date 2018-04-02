package com.willpower.study.chapter7;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import com.willpower.study.R;
import com.willpower.study.util.ToolbarHelper;
import com.willpower.study.weight.CenterPointView;

/**
 * Created by Administrator on 2018/3/30.
 * View动画:
 * View动画的作用对象是View，它支持4种动画效果，分别是位移动画（TranslateAnimation）,缩放动画（ScaleAnimation）,
 * 旋转动画（RotateAnimation），透明度动画（AlphaAnimation）；它们都继承自Animation
 * ————————————————————————————————————
 * |  名  称   |    标  签    |     子    类     |      效   果       |
 * ———————————————————————————————————
 * | 平移动画 | <translate>  |TranslateAnimation| 移动View           |
 * ———————————————————————————————————
 * |缩放动画 | <scale>      | ScaleAnimation   | 将View缩小放大     |
 * ———————————————————————————————————
 * |旋转动画 | <rotate>    | RotateAnimation  | 将View沿X轴或者Y轴旋转|
 * ———————————————————————————————————
 * |透明度动画| <alpha>    | AlphaAnimation  | 改变View透明度|
 * ———————————————————————————————————
 * 注：View动画的创建方式有两种，第一种在资源文件里静态创建，位置 res/anim/filename.xml;
 * 使用方法:
 * Animation animation = AnimationUtils.loadAnimation(R.anim.filename);
 * ImageView.startAnimation(animation);
 * 第二种：代码中动态创建；
 * RotateAnimation animation = new RotateAnimation(fromDegrees,toDegrees,pivotX,pivotY);
 * ImageView.startAnimation(animation);
 */
public class Chapter7_1Activity extends AppCompatActivity {

    CenterPointView imageTest;

    CheckBox checkBox;

    TextView tvAlpha;

    SeekBar alphaSeekBar;

    //默认的透明度
    static final float DEFAULT_ALPHA = 0.5f;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter7_1_activity);
        ToolbarHelper.initBack(this);
        ToolbarHelper.initTitle(this, "7.1 View动画");
        imageTest = (CenterPointView) findViewById(R.id.image_chapter7_1);
        checkBox = (CheckBox) findViewById(R.id.check_fill_after);
        tvAlpha = (TextView) findViewById(R.id.tv_chapter7_1_alpha);
        alphaSeekBar = (SeekBar) findViewById(R.id.seek_chapter7_1_alpha);
        tvAlpha.setText(DEFAULT_ALPHA * 100f + "%");
        alphaSeekBar.setProgress((int) (DEFAULT_ALPHA * 100));
        alphaSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvAlpha.setText(progress + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageTest.setPivoY(imageTest.getHeight() / 2);
                imageTest.setPivoX(imageTest.getWidth() / 2);
            }
        }, 500);
    }

    /**
     * onclick
     */
    public void rotate(View view) {
        imageTest.clearAnimation();
        RotateAnimation animation = new RotateAnimation(0, 360, imageTest.getPivotX(), imageTest.getPivoY());
        animation.setDuration(2000);
        animation.setFillAfter(checkBox.isChecked());
        imageTest.startAnimation(animation);
    }

    public void translate(View view) {
        imageTest.clearAnimation();
        TranslateAnimation animation = new TranslateAnimation(0, 500, 0, 0);
        animation.setDuration(2000);
        animation.setFillAfter(checkBox.isChecked());
        imageTest.startAnimation(animation);
    }

    public void scale(View view) {
        imageTest.clearAnimation();
        ScaleAnimation animation = new ScaleAnimation(1, 0.1f, 1, 0.1f, imageTest.getPivotX(), imageTest.getPivoY());
        animation.setDuration(2000);
        animation.setFillAfter(checkBox.isChecked());
        imageTest.startAnimation(animation);
    }

    public void alpha(View view) {
        imageTest.clearAnimation();
        AlphaAnimation animation = new AlphaAnimation(1, alphaSeekBar.getProgress() / 100f);
        animation.setDuration(2000);
        animation.setFillAfter(checkBox.isChecked());
        imageTest.startAnimation(animation);
    }

    public void top(View view) {
        imageTest.setPivoY(imageTest.getPivoY() - 1);
    }

    public void bottom(View view) {
        imageTest.setPivoY(imageTest.getPivoY() + 1);
    }

    public void left(View view) {
        imageTest.setPivoX(imageTest.getPivoX() - 1);
    }

    public void right(View view) {
        imageTest.setPivoX(imageTest.getPivoX() + 1);
    }
}
