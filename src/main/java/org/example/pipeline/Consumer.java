package org.example.pipeline;

abstract public class Consumer<T> extends Cacheable<T> implements Runnable {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    abstract public void consume(T e);

    abstract public boolean consumable(T e);

    abstract public void consuming();

    @Override
    public void run() {
        while (true) {
            consuming();
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
