package org.vinsguru.sec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

public class Lec01LazyStream {

    private static final Logger log = LoggerFactory.getLogger(Lec01LazyStream.class);

    public static void main(String[] args) {
        //The behaviour of Streams is lazy. It will not execute unless we connect a terminal operator.
        Stream.of(1, 2, 3, 4).peek(i -> log.info("received {}", i)).toList();


    }
}
