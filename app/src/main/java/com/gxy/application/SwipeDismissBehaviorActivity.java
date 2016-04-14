package com.gxy.application;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * 简单的滑动删除(SwipeDismissBehavior的应用)
 * Greated by Gxy on 2016/04/01
 */
public class SwipeDismissBehaviorActivity extends AppCompatActivity {

    public static Bitmap createReflectedImage(Bitmap originalImage) {

        final int reflectionGap = 0;

        int width = originalImage.getWidth();
        int height = originalImage.getHeight();

        Matrix matrix = new Matrix();
        matrix.preScale(1, -1);

        Bitmap reflectionImage = Bitmap.createBitmap(originalImage, 0,
                height / 2, width, height / 2, matrix, false);

        Bitmap bitmapWithReflection = Bitmap.createBitmap(width,
                (height + height / 2), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmapWithReflection);

        canvas.drawBitmap(originalImage, 0, 0, null);

        Paint defaultPaint = new Paint();
        canvas.drawRect(0, height, width, height + reflectionGap, defaultPaint);

        canvas.drawBitmap(reflectionImage, 0, height + reflectionGap, null);

        Paint paint = new Paint();
        LinearGradient shader = new LinearGradient(0,
                originalImage.getHeight(), 0, bitmapWithReflection.getHeight()
                + reflectionGap, 0x70ffffff, 0x00ffffff,
                Shader.TileMode.MIRROR);

        paint.setShader(shader);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));

        canvas.drawRect(0, height, width, bitmapWithReflection.getHeight()
                + reflectionGap, paint);

        return bitmapWithReflection;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipedismissbehavior);


        final TextView swipeView = (TextView) findViewById(R.id.swip);
        final ImageView image = (ImageView) findViewById(R.id.image);
        final SwipeDismissBehavior<View> swipe = new SwipeDismissBehavior();
        swipe.setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_ANY);
        swipe.setListener(
                new SwipeDismissBehavior.OnDismissListener() {
                    @Override
                    public void onDismiss(View view) {
                    }

                    @Override
                    public void onDragStateChanged(int state) {
                    }
                });
        final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
//        final CoordinatorLayout.LayoutParams coordinatorParams = (CoordinatorLayout.LayoutParams) swipeView.getLayoutParams();
//        coordinatorParams.setBehavior(swipe);
//        swipeView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (v.getId() == R.id.swip) {
//                    return swipe.onTouchEvent(coordinatorLayout, swipeView, event);
//                }
//                return false;
//            }
//        });
        final CoordinatorLayout.LayoutParams coordinatorParams1 = (CoordinatorLayout.LayoutParams) image.getLayoutParams();
        coordinatorParams1.setBehavior(swipe);
        swipeView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (v.getId() == R.id.swip) {

                    return swipe.onTouchEvent(coordinatorLayout, image, event);
                }
                return false;
            }
        });


        Bitmap bmp = ((BitmapDrawable) getResources().getDrawable(R.drawable.img)).getBitmap();
        image.setImageBitmap(createReflectedImage(bmp));

    }
}
