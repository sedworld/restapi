package com.sed.victor.restapi.flow.repos;

import com.sed.victor.restapi.base.BaseLocalDataSource;
import com.sed.victor.restapi.model.Repo;

import java.util.List;

import io.realm.RealmResults;
import rx.Single;

/**
 * Created by Victor on 08.02.2017.
 */

public class ReposLocalDataSource extends BaseLocalDataSource implements ReposDataSource {

    public Single<List<Repo>> saveRepos(List<Repo> listRepos) {
        realm.executeTransaction(realm1 -> realm.copyToRealmOrUpdate(listRepos));
        return Single.just(listRepos);
    }


    @Override
    public Single<List<Repo>> getRepos(String user) {
        return Single.create(subscriber -> {
            realm.executeTransaction(innerRealm -> {
                RealmResults<Repo> results = innerRealm.where(Repo.class).contains("name", user).findAll();
                if (results == null) {
                    subscriber.onError(new Exception("vse ploho"));
                } else {
                    List<Repo> repos = innerRealm.copyFromRealm(results);
                    if (repos != null) {
                        subscriber.onSuccess(repos);
                    } else {
                        subscriber.onError(new Exception("vse ploho2"));
                    }
                }
            });
        });
    }

    @Override
    public void clearRepos(){
    //TODO: clear local repos
    }


}
