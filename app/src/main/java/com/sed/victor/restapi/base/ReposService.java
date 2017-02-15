package com.sed.victor.restapi.base;

import com.sed.victor.restapi.model.Repo;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Single;

/**
 * Created by Victor on 08.02.2017.
 */

public interface ReposService {
    @GET("/users/{user}/repos")
    Single<List<Repo>> listRepos(@Path("user") String user);
}
