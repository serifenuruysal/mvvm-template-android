package com.androidapp.template.domain.repository

/**
 * Created by S.Nur Uysal on 2020-03-01.
 */

class Result<out V : Any, out E : Exception>(
    val value: V?,
    val error: E?
)
