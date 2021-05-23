package org.example.pipeline;

import java.util.concurrent.LinkedBlockingQueue;

abstract public class CacheableProducer<T> extends Producer<T>{

    private Cacheable<T> cache;

    public void setCache(Cacheable<T> cache) {
        this.cache = cache;
    }

    @Override
    public void cache(T e) {
       cache.cache(e);
    }

    @Override
    public boolean cacheable(T e) {
        return true;
    }

    @Override
    public void producing() {
        T e = produce();
        cache(e);
    }
}
