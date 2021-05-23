package org.example.pipeline;

import java.util.List;

public class Shunt<T> extends Cacheable<T> {

    public void shunt(List<CacheableConsumer<T>> consumers) {

        try {
            T e = buffer.take();
            consumers.forEach(c -> shuntOne(c, e));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void shuntOne(CacheableConsumer<T> consumer, T e) {

        if (consumer.cacheable(e)) {
            consumer.cache(e);
        }
    }

    @Override
    boolean cacheable(T e) {
        return true;
    }
}
