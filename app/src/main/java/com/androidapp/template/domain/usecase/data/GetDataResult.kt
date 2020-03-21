package com.androidapp.template.domain.usecase.data

import com.androidapp.template.domain.entity.Model
import com.androidapp.template.domain.usecase.UseCaseResult
/**
 * Created by S.Nur Uysal on 2020-03-01.
 */
sealed class GetDataResult : UseCaseResult {

    data class Success(val menuList: List<Model>) : GetDataResult()
    data class Error(val exception: Exception) : GetDataResult()
}
