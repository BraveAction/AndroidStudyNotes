package com.gxy.application;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Gxy on 2017/2/4
 */
public class Fragment5 extends BaseLazyFragment {

    static Bundle args;
    static Fragment5 fragment1;
    TextView textView;
    private String title;

    public static Fragment5 newInstance(String title) {
        fragment1 = new Fragment5();
        args = new Bundle();
        args.putString("key_fragment_title", title);
        fragment1.setArguments(args);
        return fragment1;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments().getString("key_fragment_title");
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        textView = new TextView(getActivity());
        textView.setText(title);
        return textView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        prepareFetchData(true);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("FRAGMENT", getClass().getSimpleName());
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void fetchData() {
        Log.d("FRAGMENT", getClass().getSimpleName());
        title = getClass().getSimpleName() + "123";
        textView.setText(title);
    }
}