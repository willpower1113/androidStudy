package com.willpower.study.weight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2018/3/30.
 * 获取点坐标的控件
 */

public class CenterPointView extends AppCompatImageView {

    private int pivoX, pivoY;

    private int circleRadios = 20;

    public CenterPointView(Context context) {
        super(context);
        init();
    }

    public CenterPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CenterPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        pivoX = circleRadios;
        pivoY = circleRadios;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        if (getPivoX() == (getWidth() / 2) && getPivoY() == (getHeight() / 2)) {
            paint.setColor(Color.BLUE);
        } else {
            paint.setColor(Color.RED);
        }
        canvas.drawOval(new RectF(getPivoX() - circleRadios, getPivoY() - circleRadios, getPivoX() + circleRadios, getPivoY() + circleRadios), paint);
        Paint black = new Paint(Paint.ANTI_ALIAS_FLAG);
        black.setColor(Color.BLACK);
        canvas.drawOval(new RectF((getWidth() / 2) - 4, (getHeight() / 2) - 4, (getWidth() / 2) + 4, (getHeight() / 2) + 4), black);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                setPivoX((int) event.getX());
                setPivoY((int) event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                setPivoX((int) event.getX());
                setPivoY((int) event.getY());
                break;
        }
        return true;
    }


    public int getPivoX() {
        return pivoX;
    }

    public void setPivoX(int pivoX) {
        this.pivoX = pivoX;
        postInvalidate();
    }

    public int getPivoY() {
        return pivoY;
    }

    public void setPivoY(int pivoY) {
        this.pivoY = pivoY;
        postInvalidate();
    }
}
