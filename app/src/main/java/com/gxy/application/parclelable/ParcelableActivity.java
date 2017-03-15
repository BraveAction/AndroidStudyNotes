package com.gxy.application.parclelable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import com.gxy.application.MainActivity;
import com.gxy.application.R;
import com.gxy.application.RecycleItemAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 实现android序列化接口的对象在Intent中的传递
 * Greated by Gxy on 2016/04/01
 */
public class ParcelableActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_itemtouchhelper);
        mToolbar = (Toolbar) findViewById(R.id.toolBar);

        setSupportActionBar(mToolbar);

        mToolbar.setMinimumHeight(100);
        UserParcelable user = getIntent().getParcelableExtra("test");
        Toast.makeText(ParcelableActivity.this, user.getTest(), Toast.LENGTH_SHORT).show();
        initRecyclerView();
    }

    /**
     * 初始
     */
    void initRecyclerView() {
        RecyclerView mRcyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRcyclerView.setHasFixedSize(true);
        mRcyclerView.setLayoutManager(new LinearLayoutManager(this, OrientationHelper.VERTICAL, false));
        final RecycleItemAdapter recycleItemAdapter = new RecycleItemAdapter(mRcyclerView, this, new MainActivity.ItemOnClickListener() {
            @Override
            public void onClick() {

            }
        });
        List<String> data = new ArrayList<>();
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


        mRcyclerView.setAdapter(recycleItemAdapter);
        recycleItemAdapter.setmData(data);
//        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(recycleItemAdapter);
        ItemTouchHelper.Callback callback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                recycleItemAdapter.notifyItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
                Collections.swap(recycleItemAdapter.getData(), viewHolder.getAdapterPosition(), target.getAdapterPosition());
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                recycleItemAdapter.onItemDismiss(viewHolder.getAdapterPosition());
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(mRcyclerView);

    }
}
