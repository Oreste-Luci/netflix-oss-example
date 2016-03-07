package com.oresteluci.sample.servicea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Oreste Luci
 */
@Service
@EnableBinding(Source.class)
public class StreamService {

    @Autowired
    @Output(Source.OUTPUT)
    private MessageChannel messageChannel;


    /*
    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "${fixedDelay}", maxMessagesPerPoll = "1"))
    public MessageSource<String> timerMessageSource() {
        return () -> new GenericMessage<>(new SimpleDateFormat("dd/MM/yyyy HH:ss").format(new Date()));
    }
    */

    public void sendMessage() {

        String uuid = UUID.randomUUID().toString();

        System.out.println("StreamService.sendMessage: " + uuid);

        this.messageChannel.send( new GenericMessage<>(uuid));
    }

}
