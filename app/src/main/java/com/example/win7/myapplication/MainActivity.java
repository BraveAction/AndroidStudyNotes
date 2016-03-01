package com.example.win7.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

/**
 * created Gxy on 2016/01/01
 */
public class MainActivity extends AppCompatActivity {

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
        toolbar.setTitleTextColor(Color.argb(255, 20, 20, 255));
//        设置子标题文本颜色
        toolbar.setSubtitleTextColor(Color.argb(255, 20, 20, 255));
//        设置ActionBar
        setSupportActionBar(toolbar);
//        ActionBar不要显示标题
        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        设置返回按键图片
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.navg);
//        显示返回按键
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
        }

        return super.onOptionsItemSelected(item);
    }
}
