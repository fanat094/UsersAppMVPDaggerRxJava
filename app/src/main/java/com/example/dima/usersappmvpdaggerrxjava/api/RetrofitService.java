package com.example.dima.usersappmvpdaggerrxjava.api;

import com.example.dima.usersappmvpdaggerrxjava.mvp.users.Users;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface RetrofitService {

    @GET("posts")
    Single<List<Users>> getUsers();

    @GET("posts")
    Observable<List<Users>> getUsersObservable();
}
