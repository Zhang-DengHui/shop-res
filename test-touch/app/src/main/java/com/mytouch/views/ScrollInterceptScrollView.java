package com.mytouch.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ScrollView;

public class ScrollInterceptScrollView extends ScrollView {
    private int downX,downY;
    private int mTouchSlop;
    public ScrollInterceptScrollView(Context context) {
        super(context);
    }

    public ScrollInterceptScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollInterceptScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                downX = (int) ev.getRawX();
                downY = (int) ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int moveY = (int) ev.getRawY();
                // 判断是否滑动，若滑动就拦截事件
                /*if (Math.abs(moveY - downY) > mTouchSlop) {
                    return true;
                }*/
                if(getScrollY() > 400){
                    scrollTo(0,400);
                    return true;
                }
                break;
            default:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
