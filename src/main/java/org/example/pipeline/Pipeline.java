package org.example.pipeline;

import org.example.util.ThreadPoolUtils;

import java.util.ArrayList;
import java.util.List;

abstract public class Pipeline<T> implements Runnable {

    List<CacheableConsumer<T>> consumers;
    List<CacheableProducer<T>> producers;
    Shunt<T> shunt;

    private Pipeline(){}

    public Pipeline(Shunt<T> shunt){
        consumers = new ArrayList<>();
        producers = new ArrayList<>();
        this.shunt = shunt;
    }

    public void addConsumer(CacheableConsumer<T> c){
        consumers.add(c);
    }

    public void addProducer(CacheableProducer<T> p){
        p.setCache(shunt);
        producers.add(p);
    }

    public void producing() {
        producers.forEach(ThreadPoolUtils::submit);
    }

    public void shunting() {

        while (true) {
            try {
                shunt.shunt(consumers);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void consuming(){
        consumers.forEach(ThreadPoolUtils::submit);
    }

    @Override
    public void run() {

        ThreadPoolUtils.submit(this::producing);
        ThreadPoolUtils.submit(this::shunting);
        ThreadPoolUtils.submit(this::consuming);
    }
}
