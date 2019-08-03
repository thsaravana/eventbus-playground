package com.madrapps.eventbus

import com.madrapps.eventbus.type.JavaType
import com.madrapps.eventbus.type.KotlinType
import org.greenrobot.eventbus.EventBus

fun main() {
    KotlinToJava().post()
}

class KotlinToJava {

    fun post() {
        val bus = EventBus.getDefault()
        val javaMain = JavaMain()

        bus.register(javaMain)
        bus.post(JavaType())
        bus.post(KotlinType())
        bus.unregister(javaMain)
    }
}