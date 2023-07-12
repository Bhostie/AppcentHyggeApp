package com.hyggeapp.barisgokmen.data.model

data class BaseResponse<T> (
    val status: String?,
    val statusCode: Int?,
    val message: String?,
    val result: T?
)