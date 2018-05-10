package com.example.dima.usersappmvpdaggerrxjava.di;

import com.example.dima.usersappmvpdaggerrxjava.mvp.users.UsersPresenterImpl;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {

   void inject(UsersPresenterImpl usersPresenterImpl);
}
