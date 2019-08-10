package com.madrapps.eventbus;

import com.madrapps.eventbus.type.JavaChildType;
import com.madrapps.eventbus.type.JavaType;
import com.madrapps.eventbus.type.KotlinType;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import static org.greenrobot.eventbus.EventBus.getDefault;

public class JavaMain {

    public static void main(String[] args) {
        new JavaMain().post();
    }

    private void post() {
        final EventBus bus = getDefault();
        final JavaObject object = new JavaObject();

        bus.register(this);
        bus.post(new JavaType());
        bus.postSticky(new JavaType());
        bus.post(new JavaChildType());
        EventBus.getDefault().post(new JavaType());
        post(new JavaType());
        postSticky(new JavaType());
        object.post(new JavaType());
        object.postSticky(new JavaType());
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

    // Wont work - 2 parameters
    @Subscribe
    public void javaMethod6(KotlinType type, KotlinType type2) {
        System.out.println("javaMethod6 executed");
    }

    // Wont work - not public
    @Subscribe
    void javaMethod7(KotlinType type) {
        System.out.println("javaMethod7 executed");
    }

    // Wont work - not public
    @Subscribe
    protected void javaMethod8(KotlinType type) {
        System.out.println("javaMethod8 executed");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void javaMethod9(JavaChildType type) {
        System.out.println("javaMethod9 executed");
    }

    public void post(JavaType type) {
        System.out.println("Non EventBus post method");
    }

    public void postSticky(JavaType type) {
        System.out.println("Non EventBus postSticky method");
    }
}
