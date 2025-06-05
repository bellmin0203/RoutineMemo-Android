package com.jm.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

fun <T, R> Flow<List<T>>.mapListToDomainModel(transform: T.() -> R): Flow<List<R>> {
    return this.map { entityList ->
        entityList.map(transform)
    }
}

fun <T, R> List<T>.mapListToDomainModel(transform: T.() -> R): List<R> {
    return this.map(transform)
}