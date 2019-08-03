package com.madrapps.eventbus;

import com.madrapps.eventbus.type.JavaType;
import com.madrapps.eventbus.type.KotlinType;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class JavaMain {

    public static void main(String[] args) {
        new JavaMain().post();
    }

    private void post() {
        final EventBus bus = EventBus.getDefault();

        bus.register(this);
        bus.post(new JavaType());
        bus.unregister(this);
    }

    // 1. Has to be public
    // 2. There should be only 1 parameter
    // 3. Can have return type
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void javaMethod(JavaType type) {
        System.out.println("javaMethod executed");
    }

    @Subscribe
    public void javaMethod1(JavaType type) {
        System.out.println("javaMethod1 executed");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public JavaType javaMethod2(JavaType type) {
        System.out.println("javaMethod2 executed");
        return null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void javaMethod3(KotlinType type) {
        System.out.println("javaMethod3 executed");
    }

    @Subscribe
    public void javaMethod4(KotlinType type) {
        System.out.println("javaMethod4 executed");
    }

    @Subscribe
    public String javaMethod5(KotlinType type) {
        System.out.println("javaMethod5 executed");
        return null;
    }
}
