package com.androidapp.template.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created by S.Nur Uysal on 2019-11-03.
 */
class FirstViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FirstViewModel() as T
    }
}