package com.example.dima.usersappmvpdaggerrxjava.mvp.users;

import java.util.List;

import io.reactivex.disposables.Disposable;

public interface UsersView {

    void showUsersData(List<Users> usersList);
    void stfull();
    void UnSubscription (Disposable subscription);
}
