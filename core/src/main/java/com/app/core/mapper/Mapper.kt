package com.app.core.mapper

interface Mapper<F, T> {

    suspend fun map(from: F): T
}