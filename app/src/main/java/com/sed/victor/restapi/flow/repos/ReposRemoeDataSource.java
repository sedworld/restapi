package com.sed.victor.restapi.flow.repos;

import com.sed.victor.restapi.base.BaseDataSource;
import com.sed.victor.restapi.base.BaseRemoteDataSource;
import com.sed.victor.restapi.base.ReposService;
import com.sed.victor.restapi.model.Repo;

import java.util.List;

import rx.Single;

/**
 * Created by Victor on 08.02.2017.
 */

public class ReposRemoeDataSource extends BaseRemoteDataSource implements ReposDataSource {



    @Override
    public Single<List<Repo>> getRepos(String user) {
        return reposService.listRepos(user);
    }

    @Override
    public void clearRepos() {

    }


}
