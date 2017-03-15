package com.gxy.application.fragment;

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
public class Fragment3 extends BaseLazyFragment {

    TextView textView;
    private String title;

    public static Fragment3 newInstance(String title) {
        Fragment3 fragment1 = new Fragment3();
        Bundle args = new Bundle();
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
    public void fetchData() {
        Log.d("FRAGMENT", title);
        textView.setText(title);
    }
}