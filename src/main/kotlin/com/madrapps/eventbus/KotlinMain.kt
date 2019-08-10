package com.madrapps.eventbus

import com.madrapps.eventbus.type.JavaType
import com.madrapps.eventbus.type.KotlinChildType
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
        bus.post(KotlinChildType())
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun kotlinMethod3(type: JavaType) {
        println("kotlinMethod3 executed")
    }

    @Subscribe
    fun kotlinMethod4(type: JavaType) {
        println("kotlinMethod4 executed")
    }

    @Subscribe
    fun kotlinMethod5(type: JavaType): String? {
        println("kotlinMethod5 executed")
        return null
    }

    // Wont work - 2 parameters
    @Subscribe
    fun kotlinMethod6(type: JavaType, type2: JavaType) {
        println("kotlinMethod6 executed")
    }

    // Wont work - not public
    @Subscribe
    private fun kotlinMethod7(type: JavaType) {
        println("kotlinMethod7 executed")
    }

    // Wont work - not public
    @Subscribe
    protected fun kotlinMethod8(type: JavaType) {
        println("kotlinMethod8 executed")
    }

    @Subscribe
    fun kotlinMethod9(type: KotlinChildType) {
        println("kotlinMethod9 executed")
    }
}