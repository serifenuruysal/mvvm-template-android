package com.androidapp.template.presentation.viewmodel

import com.androidapp.template.domain.entity.Model

/**
 * Created by S.Nur Uysal on 2020-03-01.
 */


sealed class FirstState {
    abstract val loadedAllItems: Boolean
    abstract val list: List<Model>
}

data class LoadingState(
    override val loadedAllItems: Boolean,
    override val list: List<Model>
) : FirstState()

data class LoadedState(
    override val loadedAllItems: Boolean,
    override val list: List<Model>
) : FirstState()

data class ErrorState(
    val errorMessage: String,
    override val loadedAllItems: Boolean,
    override val list: List<Model>
) : FirstState()
