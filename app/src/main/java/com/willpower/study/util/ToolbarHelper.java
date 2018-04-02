package com.willpower.study.util;

import android.app.Activity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.willpower.study.R;

/**
 * Created by Administrator on 2018/3/30.
 */

public class ToolbarHelper {

    /**
     * 设置返回事件
     */
    public static void initBack(final Activity activity) {
        Toolbar toolbar = (Toolbar) activity.findViewById(R.id.mToolbar);
        if (toolbar != null) {
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onBackPressed();
                }
            });
        }
    }

    public static void initTitle(final Activity activity, String title) {
        Toolbar toolbar = (Toolbar) activity.findViewById(R.id.mToolbar);
        if (toolbar != null) {
            toolbar.setTitle(title);
        }
    }
}
