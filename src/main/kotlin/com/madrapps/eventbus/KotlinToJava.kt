package com.madrapps.eventbus

import com.madrapps.eventbus.type.JavaChildType
import com.madrapps.eventbus.type.JavaType
import com.madrapps.eventbus.type.KotlinChildType
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
        bus.post(JavaChildType())
        bus.post(KotlinChildType())
        bus.unregister(javaMain)
    }
}