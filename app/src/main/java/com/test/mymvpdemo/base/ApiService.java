package com.test.mymvpdemo.base;

import com.test.mymvpdemo.bean.ImageBean;
import com.test.mymvpdemo.bean.JournalismBean;
import com.test.mymvpdemo.bean.NovelBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.POST;

public interface ApiService {

    @POST("novelApi")
    Observable<HttpResult<List<NovelBean>>> novelApi();

    @POST("journalismApi")
    Observable<HttpResult<JournalismBean>> journalismApi();

    @POST("meituApi")
    Observable<HttpResult<List<ImageBean>>> meituApi();

}
