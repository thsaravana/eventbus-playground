package com.madrapps.eventbus;

import com.madrapps.eventbus.type.JavaType;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class Main {

    public static void main(String[] args) {
        new Main().post();
    }

    private void post() {
        EventBus bus = EventBus.getDefault();

        bus.register(this);
        bus.post(new JavaType());
        bus.unregister(this);
    }

    // 1. Has to be public
    // 2. There should be only 1 parameter
    // 3. Can have return type
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void someMethod1(JavaType type) {
        System.out.println("Java Subscription executed");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public JavaType someMethod(JavaType type) {
        System.out.println("Java Subscription executed with return type");
        return null;
    }
}
