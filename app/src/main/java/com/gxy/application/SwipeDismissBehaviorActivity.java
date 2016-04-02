package com.example.win7.myapplication;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * 简单的滑动删除(SwipeDismissBehavior的应用)
 * Greated by Gxy on 2016/04/01
 */
public class SwipeDismissBehaviorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipedismissbehavior);


        final TextView swipeView = (TextView) findViewById(R.id.swip);
        final SwipeDismissBehavior<View> swipe = new SwipeDismissBehavior();
        swipe.setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_ANY);
        swipe.setListener(
                new SwipeDismissBehavior.OnDismissListener() {
                    @Override
                    public void onDismiss(View view) {
                    }

                    @Override
                    public void onDragStateChanged(int state) {
                        Log.i("SwipeDismissBehaviorActivity:", "onDragStateChanged");
                        Log.i("SwipeDismissBehaviorActivity:", state + "");
                        Log.i("swipeView.x:", swipeView.getX() + "");
                        Log.i("swipeView.width:", swipeView.getWidth() + "");
                        Log.i("swipeView.measuredWidth:", swipeView.getMeasuredWidth() + "");
                        if (swipe.getDragState() == SwipeDismissBehavior.STATE_DRAGGING) {
                            if (swipeView.getWidth() < swipeView.getMeasuredWidth() / 2) {
                                swipeView.setText("不好");
                            }
                        }
                    }
                });
        final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        final CoordinatorLayout.LayoutParams coordinatorParams = (CoordinatorLayout.LayoutParams) swipeView.getLayoutParams();
        coordinatorParams.setBehavior(swipe);
        swipeView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return swipe.onTouchEvent(coordinatorLayout, swipeView, event);
            }
        });
    }

}
