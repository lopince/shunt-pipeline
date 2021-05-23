package org.example.pipeline;

import java.util.concurrent.LinkedBlockingQueue;

abstract public class Cacheable<T> {

    public Cacheable(){
        buffer = new LinkedBlockingQueue<>();
    }

    protected LinkedBlockingQueue<T> buffer;

    public void cache(T e){
        buffer.offer(e);
    }

    public void take() throws InterruptedException{
        buffer.take();
    }

    abstract boolean cacheable(T e);
}
