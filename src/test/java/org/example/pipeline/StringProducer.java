package org.example.pipeline;

import java.util.Random;

public class StringProducer extends CacheableProducer<String>{

    @Override
    public String produce() {


        String msg = String.format("[%s] random int=%s", this, new Random().nextInt());

        System.out.println(msg);
        return msg;
    }
}
