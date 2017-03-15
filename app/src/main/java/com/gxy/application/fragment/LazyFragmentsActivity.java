package com.gxy.application.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.gxy.application.R;

import java.util.ArrayList;
import java.util.List;

public class LazyFragmentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(Fragment1.newInstance("Fragment1"));
        fragments.add(Fragment2.newInstance("Fragment2"));
        fragments.add(Fragment3.newInstance("Fragment3"));
        fragments.add(Fragment4.newInstance("Fragment4"));
        fragments.add(Fragment5.newInstance("Fragment5"));
        PagerAdapter pagerAdapter = new LazyFragmentPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(pagerAdapter);
    }
}
