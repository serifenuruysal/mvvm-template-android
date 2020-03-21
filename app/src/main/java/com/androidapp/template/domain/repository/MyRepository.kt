package com.androidapp.template.domain.repository

import com.androidapp.template.domain.entity.Model
import io.reactivex.Single

/**
 * Created by S.Nur Uysal on 2020-03-01.
 */
interface MyRepository {
    fun getData(page: Int): Single<Result<List<Model>,Exception>>

    fun getDetailData(eventId: Int): Single<Result<List<Model>,Exception>>
}