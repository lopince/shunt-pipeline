package org.example.pipeline;

import org.example.util.ThreadPoolUtils;

public class StringPipeline extends Pipeline<String> {

    public StringPipeline(Shunt<String> shunt) {
        super(shunt);
    }

    public static void main(String[] args) {

        StringShunt shunt = new StringShunt();

        StringProducer producer_1 = new StringProducer();
        producer_1.setName("producer_1");
        StringProducer producer_2 = new StringProducer();
        producer_2.setName("producer_2");

        StringConsumer consumer_1 = new StringConsumer();
        consumer_1.setName("consumer_1");
        StringConsumer consumer_2 = new StringConsumer();
        consumer_2.setName("consumer_2");

        StringPipeline pipeline = new StringPipeline(shunt);
        pipeline.addProducer(producer_1);
        pipeline.addProducer(producer_2);
        pipeline.addConsumer(consumer_1);
        pipeline.addConsumer(consumer_2);

        ThreadPoolUtils.submit(pipeline);
    }
}
