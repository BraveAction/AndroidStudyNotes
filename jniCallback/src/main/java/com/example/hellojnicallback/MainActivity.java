/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.hellojnicallback;

import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /**
     *loadLibrary在扫描java库路径时, 一旦发现同名的库,立即加载共享库,因为java库路径的第一组目录是android系统目录
     * 为了避免与系统库命名冲突,强烈建议android开发人员为每个共享库选择唯一的名字
     */
    static {
        System.loadLibrary("hello-jnicallback");
    }

    int hour = 0;
    int minute = 0;
    int second = 0;
    TextView tickView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tickView = (TextView) findViewById(R.id.tickView);
    }

    @Override
    public void onResume() {
        super.onResume();
        hour = minute = second = 0;
        ((TextView) findViewById(R.id.hellojniMsg)).setText(stringFromJNI());
        startTicks();
    }

    @Override
    public void onPause() {
        super.onPause();
        StopTicks();
    }

    /*
     * A function calling from JNI to update current timer
     */
    @Keep
    private void updateTimer() {
        ++second;
        if (second >= 60) {
            ++minute;
            second -= 60;
            if (minute >= 60) {
                ++hour;
                minute -= 60;
            }
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String ticks = "" + MainActivity.this.hour + ":" +
                        MainActivity.this.minute + ":" +
                        MainActivity.this.second;
                MainActivity.this.tickView.setText(ticks);
            }
        });
    }

    public native String stringFromJNI();

    public native void startTicks();

    public native void StopTicks();
}
