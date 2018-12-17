package com.example.reshap03.tbpmob.server;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class appController extends Application {
    private static final String tag = appController.class.getSimpleName();
    private static appController instance;
    RequestQueue mrequest;



    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static synchronized appController getInstance(){
        return instance;
    }

    private RequestQueue getrequesque(){
        if(mrequest == null){
            mrequest = Volley.newRequestQueue(getApplicationContext());
        }

        return mrequest;
    }

    public <T> void addToRequestQue(Request<T> req, String ttag){
        req.setTag(TextUtils.isEmpty(ttag)? tag : ttag);
        getrequesque().add(req);
    }

    public <T> void addToRequestQue(Request<T> req){
        req.setTag(tag);
        getrequesque().add(req);
    }

    public void cancelallrequest(Object req){
        if(mrequest != null){
            mrequest.cancelAll(req);
        }
    }
}
