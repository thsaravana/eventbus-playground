package com.madrapps.eventbus;

import com.madrapps.eventbus.type.JavaType;
import com.madrapps.eventbus.type.KotlinType;
import org.greenrobot.eventbus.EventBus;

public class JavaToKotlin {

    public static void main(String[] args) {
        new JavaToKotlin().post();
    }

    private void post() {
        final EventBus bus = EventBus.getDefault();

        final KotlinMain kotlinMain = new KotlinMain();

        bus.register(kotlinMain);
        bus.post(new KotlinType());
        bus.post(new JavaType());
        bus.unregister(kotlinMain);
    }
}
