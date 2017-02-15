package com.sed.victor.restapi.flow.repos.view;

import android.content.Context;
import android.support.annotation.NonNull;

import com.sed.victor.restapi.flow.repos.ReposDataSource;
import com.sed.victor.restapi.flow.repos.ReposRepository;
import com.sed.victor.restapi.model.Repo;

import java.util.List;

import rx.Single;
import rx.Subscription;
import rx.internal.util.SubscriptionList;

/**
 * Created by Victor on 13.02.2017.
 */

public class ReposPresenter implements ReposDataSource{

    private ReposView mView = null;

    private ReposRepository mReposRepository = new ReposRepository();
    private SubscriptionList subscriptionList = new SubscriptionList();

    public void onAttachToView(@NonNull ReposView reposView) {
        mView = reposView;
        mReposRepository.init(reposView.getContext());
    }

    public void onDettach(){
        subscriptionList.unsubscribe();
    }

    @Override
    public Single<List<Repo>> getRepos(String user) {
        Single<List<Repo>> single = mReposRepository.getRepos(user);
        Subscription subscription = single.subscribe(
                list -> mView.showRepos(list),
                Throwable::printStackTrace);
        subscriptionList.add(subscription);
        return single;
    }

    @Override
    public void clearRepos() {
        mReposRepository.clearRepos();

    }

    @Override
    public void init(Context context) {

    }
}
