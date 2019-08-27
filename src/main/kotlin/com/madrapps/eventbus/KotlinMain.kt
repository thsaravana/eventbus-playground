package com.madrapps.eventbus

import com.madrapps.eventbus.type.*
import com.madrapps.eventbus.type.KotlinEnumType.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

fun main() {
    KotlinMain().post()
    KotlinMain().postTopLevel()
}

class KotlinMain {

    fun post() {
        val bus = EventBus.getDefault()
        val kotlinObject = KotlinObject()

        bus.register(this)
        bus
            .post (
                KotlinType()
            )
        bus.post(KotlinChildType())
        EventBus.getDefault().post(KotlinType())
        bus.postSticky(KotlinType())
        with(bus) {
            post(KotlinType())
            postSticky(KotlinType())
        }
        bus.post(KotlinEnumType.ONE)
        bus.post(ONE)
        bus.post(KotlinInnerEnum.EnumType.ONE)
        post(KotlinType())
        postSticky(KotlinType())
        kotlinObject.post(KotlinType())
        kotlinObject.postSticky(KotlinType())
        bus.unregister(this)
    }

    fun postTopLevel() {
        val bus = EventBus.getDefault()
        bus.register(this)
        topLevelFunction(bus)
        postExtension(bus)
        bus.postType()
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

    fun post(type: KotlinType) {
        println("Non EventBus post method")
    }

    fun postSticky(type: KotlinType) {
        println("Non EventBus postSticky method")
    }

    @Subscribe
    fun kotlinMethod10(type: KotlinEnumType) {
        println("kotlinMethod10 executed")
    }

    @Subscribe
    fun kotlinMethod11(type: KotlinInnerEnum.EnumType) {
        println("kotlinMethod11 executed")
    }
}

private fun topLevelFunction(bus: EventBus) {
    bus.post(JavaType())
    bus.post(KotlinType())
}

private fun KotlinMain.postExtension(bus: EventBus) {
    bus.post(JavaType())
    bus.post(KotlinType())
}

private fun EventBus.postType() {
    this.post(JavaType())
    this.post(KotlinType())
    post(JavaType())
    post(KotlinType())
}