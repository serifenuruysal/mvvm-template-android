package com.androidapp.template.domain.usecase.data

import com.androidapp.template.domain.repository.MyRepository
import com.androidapp.template.domain.usecase.UseCase
import io.reactivex.Single

/**
 * Created by S.Nur Uysal on 2020-02-25.
 */
class GetDataUseCase(private val repository: MyRepository) :
    UseCase<GetDataResult> {

    fun getDataList(page: Int): Single<GetDataResult> {
        return repository.getData(page).map { result ->
            if (result.error == null) {
                GetDataResult.Success(result.value!!)
            } else {
                GetDataResult.Error(result.error)
            }
        }
    }

}