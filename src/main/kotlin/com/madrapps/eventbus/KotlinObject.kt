package com.madrapps.eventbus

import com.madrapps.eventbus.type.KotlinType

class KotlinObject {

    fun post(type: KotlinType) {
        println("Non EventBus post method")
    }

    fun postSticky(type: KotlinType) {
        println("Non EventBus postSticky method")
    }
}