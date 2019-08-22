package com.madrapps.eventbus;

import com.madrapps.eventbus.type.*;
import org.greenrobot.eventbus.EventBus;

import static com.madrapps.eventbus.type.KotlinEnumType.*;

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
        bus.post(new JavaChildType());
        bus.post(new KotlinChildType());
        bus.post(KotlinEnumType.ONE);
        bus.post(ONE);
        bus.unregister(kotlinMain);
    }
}
