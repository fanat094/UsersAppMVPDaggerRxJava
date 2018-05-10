package com.example.dima.usersappmvpdaggerrxjava.mvp.users;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dima.usersappmvpdaggerrxjava.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder>{

    List<Users> usersList;

    public UsersAdapter(List<Users> usersList) {
        this.usersList = usersList;
    }

    @NonNull
    @Override
    public UsersAdapter.UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.usersreating_list_row, parent, false);

        return new UsersViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.UsersViewHolder holder, int position) {

        Users users = usersList.get(position);

        holder.userId.setText(Integer.toString(users.getUserId()));
        holder.id.setText(Integer.toString(users.getId()));
        holder.title.setText(users.getTitle());
        holder.body.setText(users.getBody());

    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class UsersViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.userId_tv) TextView userId;
        @BindView(R.id.id_tv) TextView id;
        @BindView(R.id.title_tv) TextView title;
        @BindView(R.id.body_tv) TextView body;

       public UsersViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
