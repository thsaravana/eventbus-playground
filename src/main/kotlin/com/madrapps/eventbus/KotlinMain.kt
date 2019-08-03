package com.madrapps.eventbus

import com.madrapps.eventbus.type.KotlinType
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

fun main() {
    KotlinMain().post()
}

class KotlinMain {

    fun post() {
        val bus = EventBus.getDefault()

        bus.register(this)
        bus.post(KotlinType())
        bus.unregister(this)
    }

    // 1. Has to be public
    // 2. There should be only 1 parameter
    // 3. Can have return type
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun kotlinMethod(type: KotlinType) {
        println("kotlinMethod executed")
    }

    @Subscribe
    fun kotlinMethod1(type: KotlinType) {
        println("kotlinMethod1 executed")
    }

    @Subscribe
    fun kotlinMethod2(type: KotlinType): String? {
        println("kotlinMethod2 executed")
        return null
    }
}