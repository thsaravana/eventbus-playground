package com.madrapps.eventbus

import com.madrapps.eventbus.type.*
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
        bus.post(JavaEnumType.ONE)
        bus.unregister(javaMain)
    }
}