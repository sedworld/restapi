package com.sed.victor.restapi.flow.repos;

import com.sed.victor.restapi.base.BaseDataSource;
import com.sed.victor.restapi.model.Repo;

import java.util.List;

import rx.Single;

/**
 * Created by Victor on 08.02.2017.
 */

public interface ReposDataSource extends BaseDataSource{

    public Single<List<Repo>> getRepos(String user);
    public void clearRepos();
}
