package org.example.pipeline;

import java.util.concurrent.LinkedBlockingQueue;

abstract public class CacheableConsumer<T> extends Consumer<T>{

    @Override
    public void cache(T e) {
        buffer.offer(e);
    }

    @Override
    public boolean cacheable(T e) {
        return consumable(e);
    }

    @Override
    public void consuming() {
        try{
            T e = buffer.take();
            consume(e);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
