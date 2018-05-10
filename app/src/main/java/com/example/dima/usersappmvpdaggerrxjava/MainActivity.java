package com.example.dima.usersappmvpdaggerrxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.dima.usersappmvpdaggerrxjava.mvp.users.Users;
import com.example.dima.usersappmvpdaggerrxjava.mvp.users.UsersAdapter;
import com.example.dima.usersappmvpdaggerrxjava.mvp.users.UsersPresenterImpl;
import com.example.dima.usersappmvpdaggerrxjava.mvp.users.UsersView;
import com.gturedi.views.StatefulLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity implements UsersView {

    private UsersAdapter usersAdapter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.stateful_view)
    StatefulLayout st;

    UsersPresenterImpl usersPresenter;
    Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        usersPresenter = new UsersPresenterImpl();
        usersPresenter.attachView(this);
        usersPresenter.getUsersRequestObservable();
        st.showLoading();
    }

    @Override
    public void showUsersData(List<Users> usersList) {

        Log.e("usersList-->", ""+usersList.get(0).getId());

        usersAdapter = new UsersAdapter(usersList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(usersAdapter);
        st.showContent();

    }

    @Override
    public void stfull() {

        st.showEmpty();
    }

    @Override
    public void UnSubscription(Disposable subscription) {
        disposable = subscription;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
        Log.e("UnSubscription", "UnSubscription");
    }
}
