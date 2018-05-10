package com.example.dima.usersappmvpdaggerrxjava.mvp.users;

import android.content.res.Resources;
import android.util.Log;

import com.example.dima.usersappmvpdaggerrxjava.BaseApplication;
import com.example.dima.usersappmvpdaggerrxjava.api.RetrofitService;

import org.reactivestreams.Subscription;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class UsersPresenterImpl {

    @Inject
    Resources resources;
    @Inject
    RetrofitService retrofitService;

    UsersView view;

    Disposable subscription;

    public void attachView(UsersView view) {
        this.view = view;
    }

    public UsersPresenterImpl() {
        BaseApplication.getAppComponent().inject(this);
    }

    public void getUsersRequestObservable() {

        subscription = retrofitService.getUsersObservable().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(usersList -> {
                    view.showUsersData(usersList);
                    view.UnSubscription(subscription);
                }, err -> {
                    err.printStackTrace();
                    view.stfull();
                });
    }
}
