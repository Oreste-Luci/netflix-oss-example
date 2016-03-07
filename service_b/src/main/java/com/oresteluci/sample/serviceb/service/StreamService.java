package com.oresteluci.sample.serviceb.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * @author Oreste Luci
 */
@EnableBinding(Sink.class)
public class StreamService {

    @ServiceActivator(inputChannel = Sink.INPUT)
    public void readMessage(Object message) {
        System.out.println("Message Received: " + message);
    }
}
