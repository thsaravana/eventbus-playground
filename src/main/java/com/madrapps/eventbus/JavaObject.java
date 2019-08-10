package com.madrapps.eventbus;

import com.madrapps.eventbus.type.JavaType;

public class JavaObject {

    public void post(JavaType type) {
        System.out.println("Non EventBus post method");
    }

    public void postSticky(JavaType type) {
        System.out.println("Non EventBus postSticky method");
    }
}
