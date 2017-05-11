package com.example.demo.json;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by DEMO on 06-10-2016.
 */
public class VollyJson extends Application {
    private static VollyJson mInstance;
    private RequestQueue mRequestQueue;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
        mRequestQueue = getRequestQueue();
    }

    public static VollyJson getmInstance(){
        return mInstance;
    }
    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(this);
        }
        return mRequestQueue;
    }

}
