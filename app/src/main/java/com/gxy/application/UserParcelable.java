package com.example.win7.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 实现android序列化接口,在Intent中传递
 * Created by Gxy on 2016/03/03.
 */
public class UserParcelable implements Parcelable {
    String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public UserParcelable() {
    }

    protected UserParcelable(Parcel in) {
        test = in.readString();
    }

    public static final Creator<UserParcelable> CREATOR = new Creator<UserParcelable>() {
        @Override
        public UserParcelable createFromParcel(Parcel in) {
            return new UserParcelable(in);
        }

        @Override
        public UserParcelable[] newArray(int size) {
            return new UserParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(test);
    }
}
