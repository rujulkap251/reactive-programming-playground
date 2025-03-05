package org.vinsguru.sec01;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vinsguru.sec01.publisher.PublisherImpl;
import org.vinsguru.sec01.subscriber.SubscriberImpl;

/*
    In this class, we will be verifying the simple rules of reactive programming
    1. publisher does not produce data unless subscriber requests for it.
    2. publisher will produce only <= subscriber requested items. publisher can also produce 0 items!
    3. subscriber can cancel the subscription. producer should stop at the moment as subscriber is no longer interested in consuming the data
    4. producer can send the error signal to indicate something is wrong.
 */
public class Demo {

    private static final Logger log = LoggerFactory.getLogger(Demo.class);
    public static void main(String[] args) throws InterruptedException {
        //demo1();
        //demo2();
        //demo3();
        //demo4();
        demo5();
    }

    private static void demo1() {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
    }

    /**
     * publisher will produce only <= subscriber requested items.
     * @throws InterruptedException
     */
    private static void demo2() throws InterruptedException {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
        subscriber.getSubscription().request(3);
    }

    /**
     * publisher can also produce 0 items!
     * If we change MAX_INT items to 0, producer will produce 0 items
     * @throws InterruptedException
     */
    private static void demo3() throws InterruptedException {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
    }

    /**
     * subscriber can cancel the subscription.
     * @throws InterruptedException
     */
    private static void demo4() throws InterruptedException {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);

    }

    /**
     * producer can send the error signal to indicate something is wrong.
     * @throws InterruptedException
     */
    private static void demo5() throws InterruptedException {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
        subscriber.getSubscription().request(11);
        Thread.sleep(2000);
        subscriber.getSubscription().request(11);
    }


}