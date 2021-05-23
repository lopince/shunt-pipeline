package org.example.pipeline;

public class StringConsumer extends CacheableConsumer<String>{

    @Override
    public void consume(String e) {

        System.out.printf("[%s] Consuming msg=%s\n", this, e);
    }

    @Override
    public boolean consumable(String e) {
        return true;
    }
}
