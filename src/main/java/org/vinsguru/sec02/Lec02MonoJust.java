package org.vinsguru.sec02;

import org.reactivestreams.Publisher;
import org.vinsguru.sec01.subscriber.SubscriberImpl;
import reactor.core.publisher.Mono;

public class Lec02MonoJust {

    public static void main(String[] args) {

        //This will create a Publisher that will emit 'abcd'.
        //Mono.just accept any type.
        var mono = Mono.just("abcd");

        //If we just print mono, it will not print out 'abcd' because the publisher will only emit items
        // after the subscriber subscribes and requests an item.
        //System.out.println(mono);

        //Creating a subscriber and subscribing to the publisher
        var subscriber = new SubscriberImpl();
        mono.subscribe(subscriber);
        //Requesting items from publisher
        subscriber.getSubscription().request(10);

        //If we have already requested for 1tems and the publisher has called onComplete
        //then even if we request for more items the below will not be called as the subscription has been
        //completed. So the request and cancel methods have no impact
        subscriber.getSubscription().request(10);
        subscriber.getSubscription().cancel();
    }

    /**
     * Lets imagine that we have a "abcd" in a variable somewhere in the memory. Now we want to save this variable in
     * a DB. Here, the DB is the subscriber while the place from where we are sending this variable will be a publisher.
     * We can imagine there is a library that provides the method to save in DB (something like the below that extracts
     * values from publisher and pushes it to DB), so to provide the variable abcd, we will need to create a publisher
     * and one way to do it is using Mono.just
     *
     * @param publisher
     */
    private static void save(Publisher<String> publisher){

    }
}
