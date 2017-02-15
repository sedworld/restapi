package com.sed.victor.restapi.flow.repos;

import android.content.Context;

import com.sed.victor.restapi.model.Repo;

import java.util.List;

import rx.Single;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by Victor on 13.02.2017.
 */

public class ReposRepository implements ReposDataSource{
    private ReposLocalDataSource mReposLocalDataSource = new ReposLocalDataSource();
    private ReposRemoeDataSource mReposRemoeDataSource = new ReposRemoeDataSource();

    @Override
    public Single<List<Repo>> getRepos(String user) {
        return mReposRemoeDataSource.getRepos(user).flatMap(list -> mReposLocalDataSource.saveRepos(list))
                .onErrorResumeNext(mReposLocalDataSource.getRepos(user))
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public void clearRepos() {
        mReposLocalDataSource.clearRepos();
    }

    @Override
    public void init(Context context) {
        mReposLocalDataSource.init(context);
        mReposRemoeDataSource.init(context);
    }
}
