package com.sed.victor.restapi.flow.repos.view;

import android.content.Context;

import java.util.List;

import rx.Single;

/**
 * Created by Victor on 13.02.2017.
 */

public interface ReposView {
    Context getContext();

    void showRepos(List list);
}
