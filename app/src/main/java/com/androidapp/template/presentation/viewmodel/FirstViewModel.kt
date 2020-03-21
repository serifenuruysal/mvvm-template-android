package com.androidapp.template.presentation.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.androidapp.template.data.repository.MyRepositoryImpl
import com.androidapp.template.domain.usecase.UseCaseResult
import com.androidapp.template.domain.usecase.data.GetDataResult
import com.androidapp.template.domain.usecase.data.GetDataUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by S.Nur Uysal on 2020-02-11.
 */


class FirstViewModel : ViewModel() {

    val stateLiveData = MutableLiveData<FirstState>()
    private var repository = MyRepositoryImpl()

    init {
        stateLiveData.value =
            LoadingState(false, emptyList())
    }

    @SuppressLint("CheckResult")
    fun getData() {
        val useCase = GetDataUseCase(repository)
        useCase.getDataList(1)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::onDataResponseReceived, this::onError)
    }


    private fun onDataResponseReceived(result: UseCaseResult) {
        when (result) {
            is GetDataResult.Success -> {
                stateLiveData.value =
                    LoadedState(
                        true,
                        result.menuList
                    )

            }
            is GetDataResult.Error -> {
                stateLiveData.value =
                    ErrorState(
                        result.exception.localizedMessage!!,
                        false,
                        emptyList()
                    )
            }
        }
    }

    private fun onError(error: Throwable) {
        stateLiveData.value =
            ErrorState(
                error.message ?: "",
                false,
                emptyList()
            )
    }


}