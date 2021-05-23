package org.example.pipeline;

abstract public class Producer<T> extends Cacheable<T> implements Runnable {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    abstract public T produce();

    abstract public void producing();

    @Override
    public void run() {
        while (true) {
            producing();
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
