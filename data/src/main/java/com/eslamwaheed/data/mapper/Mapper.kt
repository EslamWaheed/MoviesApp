package com.eslamwaheed.data.mapper

interface Mapper<T : Any, V : Any> {
    operator fun invoke(data: T): V
}