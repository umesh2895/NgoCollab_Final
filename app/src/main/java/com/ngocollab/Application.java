package com.ngocollab;

public class Application extends android.app.Application {
    private SharedPrefs sharedPrefs;
    private static Application app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        sharedPrefs = new SharedPrefs(this);
    }

    public static Application getApp() {
        return app;
    }

    public SharedPrefs getSharedPrefs() {
        return sharedPrefs;
    }

    public void setSharedPrefs(SharedPrefs sharedPrefs) {
        this.sharedPrefs = sharedPrefs;
    }
}