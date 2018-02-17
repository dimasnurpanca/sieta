package com.dnp.sieta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

public class MainActivity extends android.app.Application {
    private static Bus mEventBus;

    public static Bus getBus() {
        return mEventBus;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mEventBus = new Bus(ThreadEnforcer.ANY);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}