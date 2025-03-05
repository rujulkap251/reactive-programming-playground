package org.vinsguru.sec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

/**
 * Testing the overloaded subscribe methods that comes with Mono
 */
public class Lec03MonoSubscribe {

    public static final Logger log = LoggerFactory.getLogger(Lec03MonoSubscribe.class);

    public static void main(String[] args) {

        var mono = Mono.just(1);

        //First, we have a subscribe method that consumes. Note that Reactor library also performs
        // subscriber.getSubscription().request() for the one and only item in the mono
        //mono.subscribe(i -> log.info("Received: {}", i));

        //Subscribing by passing the consumer of throwable (as it gives us the Throwable error object)
        //mono.subscribe(i -> log.info("Received: {}", i), err -> log.error("Error: ", err));

        //Subscribing by passing the Runnable for onComplete (as the onComplete method does not return anything)
        //mono.subscribe(i -> log.info("Received: {}", i), err -> log.error("Error: ", err), () -> log.info("Completed!"));

        //We can also choose to request items or cancel subscription by passing in the consumer of the subscription
        // object
        //mono.subscribe(i -> log.info("Received: {}", i), err -> log.error("Error: ", err), () -> log.info("Completed!"), subscription -> subscription.request(10));

        //We can also cancel the subscription. In that case, we receive no items.
        //mono.subscribe(i -> log.info("Received: {}", i), err -> log.error("Error: ", err), () -> log.info("Completed!"), subscription -> subscription.request(10));


        //We can also provide a transformation to mono. This works the same way as streams i.e. the map function does not get executed until the data from mono2 is requested
        //Hence, when the request method is called, we receive 1a
        //var mono2 = Mono.just(1).map(i -> i + "a");
        //mono2.subscribe(i -> log.info("Received: {}", i), err -> log.error("error", err), () -> log.info("Completed!"), subscription -> subscription.request(10));

        //To simulate error conditions, we do a 1/0
        var mono3 = Mono.just(1).map(i -> i / 0);
        mono3.subscribe(i -> log.info("Received: {}", i), err -> log.error("error", err), () -> log.info("Completed!"), subscription -> subscription.request(10));
    }
}
