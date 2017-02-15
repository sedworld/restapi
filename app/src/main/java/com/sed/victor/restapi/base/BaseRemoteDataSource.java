package com.sed.victor.restapi.base;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * Created by Victor on 08.02.2017.
 */

public abstract class BaseRemoteDataSource implements BaseDataSource{

    private static final String NEWS_ENDPOINT = "https://api.github.com/";

    protected ReposService reposService = null;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(NEWS_ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build();
    
    @Override
    public void init(Context context) {

        reposService = retrofit.create(ReposService.class);
    }

}
