package com.androidapp.template.data.repository

import com.androidapp.template.data.service.ApiService
import com.androidapp.template.domain.entity.Model
import com.androidapp.template.domain.repository.MyRepository
import com.androidapp.template.domain.repository.Result
import io.reactivex.Single

/**
 * Created by S.Nur Uysal on 2020-03-01.
 */
class MyRepositoryImpl() :
    MyRepository {
    private val restApi = ApiService.create()
    override fun getData(page: Int): Single<Result<List<Model>, Exception>> {
        return restApi.getData(page)
            .map { response ->
                if (response.list.isNotEmpty()) {
                    Result<List<Model>, Exception>(response.list, null)

                } else {
                    Result(null, Exception())
                }
            }
            .onErrorReturn { Result<List<Model>, Exception>(null, Exception()) }
    }

    override fun getDetailData(eventId: Int): Single<Result<List<Model>, Exception>> {
        return restApi.getDetailData(eventId)
            .map { response ->
                if (response.list.isNotEmpty()) {
                    Result<List<Model>, Exception>(response.list, null)

                } else {
                    Result(null, Exception())
                }
            }
            .onErrorReturn { Result<List<Model>, Exception>(null, Exception()) }
    }

}