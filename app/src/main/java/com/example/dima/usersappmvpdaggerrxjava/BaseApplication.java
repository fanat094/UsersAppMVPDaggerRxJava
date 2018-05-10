package com.example.dima.usersappmvpdaggerrxjava;

import android.app.Application;
import com.example.dima.usersappmvpdaggerrxjava.di.AppComponent;
import com.example.dima.usersappmvpdaggerrxjava.di.AppModule;
import com.example.dima.usersappmvpdaggerrxjava.di.DaggerAppComponent;

public class BaseApplication extends Application{

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
