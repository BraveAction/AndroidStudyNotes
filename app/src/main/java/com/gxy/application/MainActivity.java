package com.gxy.application;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * created Gxy on 2016/01/01
 */
public class MainActivity extends AppCompatActivity {
    private String TAG = getClass().getSimpleName();
    private FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        设置标题
        toolbar.setTitle(getTitle());
//        设置子标题
        toolbar.setSubtitle(getTitle());
//        设置导航按键
//        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.navg));
//        设置标题文本颜色
        toolbar.setTitleTextColor(0xFFC000);
//        设置子标题文本颜色
        toolbar.setSubtitleTextColor(Color.argb(255, 20, 20, 255));
//        设置ActionBar
//        ActionBar不要显示标题
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
//        设置返回按键图片
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
//        显示返回按键
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//      初始化浮动按钮
        initFAB();
        initRecyclerView();
        initCollapsingToolbarLayout();
    }


    void initFAB() {
        ImageView toolBarImage = (ImageView) findViewById(R.id.toolBarImage);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.yc);
        Bitmap src = bitmapDrawable.getBitmap();
        Bitmap dst;
//将长方形图片裁剪成正方形图片
        if (src.getWidth() >= src.getHeight()) {
            dst = Bitmap.createBitmap(src, src.getWidth() / 2 - src.getHeight() / 2, 0, src.getHeight(), src.getHeight()
            );
        } else {
            dst = Bitmap.createBitmap(src, 0, src.getHeight() / 2 - src.getWidth() / 2, src.getWidth(), src.getWidth()
            );
        }
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), dst);
        roundedBitmapDrawable.setCornerRadius(dst.getWidth() / 2);
        roundedBitmapDrawable.setAntiAlias(true);
        toolBarImage.setImageDrawable(roundedBitmapDrawable);
        toolBarImage.invalidate();

        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar snackbar = Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mFloatingActionButton.setImageResource(R.drawable.voice);
                            }
                        });
                snackbar.getView().setBackgroundColor(0xfff44336);
                snackbar.show();
            }
        });
    }

    /**
     * 实现NestedScrollView 嵌套recyclerView
     */
    void initRecyclerView() {
        final List<String> data = new ArrayList<>();
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new MyLinearLayoutManager(this, OrientationHelper.VERTICAL, false));

//        SimpleItemAnimator defaultItemAnimator = (SimpleItemAnimator) recyclerView.getItemAnimator();
//        defaultItemAnimator.setSupportsChangeAnimations(false);
//        defaultItemAnimator.setMoveDuration(0);

        final RecycleItemAdapter recycleItemAdapter = new RecycleItemAdapter(recyclerView, this, new ItemOnClickListener() {
            @Override
            public void onClick() {
                Log.i(getClass().getSimpleName(), "456");
            }
        });
        data.add("1");
        data.add("2");
        data.add("3");
        data.add("4");
        data.add("5");
        data.add("6");
        data.add("7");
        data.add("8");
        data.add("9");
        data.add("10");
        data.add("11");
        data.add("12");
        data.add("13");
        data.add("14");
        data.add("15");
        data.add("16");
        data.add("17");
        data.add("18");
        data.add("19");

        recyclerView.setAdapter(recycleItemAdapter);
        recycleItemAdapter.setmData(data);
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(recycleItemAdapter);
        ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(recyclerView);

        //滑动时会通知到CollapsingToolbarLayout
        recyclerView.setNestedScrollingEnabled(false);
//        recyclerView.setItemAnimator(new SimpleItemAnimator() {
//
//            @Override
//            public void onRemoveFinished(RecyclerView.ViewHolder item) {
//                Log.d(TAG, "onRemoveFinished");
//                recycleItemAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public boolean animateRemove(RecyclerView.ViewHolder holder) {
//                Log.d(TAG, "animateRemove");
//                return true;
//            }
//
//            @Override
//            public boolean animateAdd(RecyclerView.ViewHolder holder) {
//                Log.d(TAG, "animateAdd");
//                return true;
//            }
//
//            @Override
//            public boolean animateMove(RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
//                Log.d(TAG, "animateMove");
//                return true;
//            }
//
//            @Override
//            public boolean animateChange(RecyclerView.ViewHolder oldHolder, RecyclerView.ViewHolder newHolder, int fromLeft, int fromTop, int toLeft, int toTop) {
//                Log.d(TAG, "animateChange");
//                return true;
//            }
//
//            @Override
//            public void runPendingAnimations() {
//                Log.d(TAG, "runPendingAnimations");
//            }
//
//            @Override
//            public void endAnimation(RecyclerView.ViewHolder item) {
//                Log.d(TAG, "endAnimation");
//            }
//
//            @Override
//            public void endAnimations() {
//                Log.d(TAG, "endAnimations");
//            }
//
//            @Override
//            public boolean isRunning() {
//                Log.d(TAG, "isRunning");
//                return false;
//            }
//        });
    }


    void initCollapsingToolbarLayout() {

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        collapsingToolbarLayout.setExpandedTitleColor(0xFFC000);
//        collapsingToolbarLayout.setCollapsedTitleTextColor(0xFFC000);
        collapsingToolbarLayout.setTitle("你好!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.edit) {
//            Intent intent = new Intent(getApplicationContext(), Main22Activity.class);
//            startActivity(intent);
        } else if (id == R.id.edit1) {
//            UserParcelable user = new UserParcelable();
//            user.setTest("你好");
//            Intent intent = new Intent(getApplicationContext(), ParcelableActivity.class);
//            intent.putExtra("test", user);
//            startActivityForResult(intent, 1);
            startActivity(new Intent(getApplicationContext(), Main3Activity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == android.app.Activity.RESULT_OK) {
            }
        }
    }

    interface ItemOnClickListener {
        void onClick();
    }
}
