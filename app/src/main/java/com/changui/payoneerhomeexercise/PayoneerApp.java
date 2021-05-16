package com.changui.payoneerhomeexercise;



import androidx.multidex.MultiDexApplication;

import com.facebook.drawee.backends.pipeline.Fresco;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class PayoneerApp extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
