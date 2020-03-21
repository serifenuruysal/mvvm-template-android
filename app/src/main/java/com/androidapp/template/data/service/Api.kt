package com.androidapp.template.data.service

import com.androidapp.template.domain.entity.MyResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by S.Nur Uysal on 2020-02-28.
 */

interface Api {
    @GET("path1")
    fun getData(@Query("page") page: Int): Single<MyResponse>

    @GET("path2/{id}")
    fun getDetailData(@Path("id") eventId: Int): Single<MyResponse>
}