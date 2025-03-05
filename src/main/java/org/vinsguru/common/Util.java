package org.vinsguru.common;

import org.reactivestreams.Subscriber;
import reactor.core.publisher.Mono;

public class Util {

    public static <T> Subscriber<T> subscriber(){
        return new DefaultSubscriber<>("");
    }

    public static <T> Subscriber<T> subscriber(String name){
        return new DefaultSubscriber<>(name);
    }

    //Testing if the above new DefaultSubscriber works
    public static void main(String[] args) {
        var mono = Mono.just(1);

        //mono.subscribe(subscriber());
        //mono.subscribe(subscriber("sub1"));
        //mono.subscribe(subscriber("sub2"));
    }
}
