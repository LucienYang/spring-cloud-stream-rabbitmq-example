package com.jhinno.streamrabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author: lyang
 * @Date: 2018/12/29 16:35
 */
@Component
@Slf4j
@EnableBinding(MyProcessor.class)
public class MyMQReciver {

    @StreamListener(MyProcessor.INPUT)
    @SendTo(MyProcessor.CALLBACKINPUT)
    public String process(MyGirl myGirl){
        log.info("message comming : {} ", myGirl.toString());
        return myGirl.toString();
    }

    @StreamListener(MyProcessor.CALLBACKINPUT)
    public void callback(String myGirl){
        log.info("message has recived : {} ", myGirl);
    }
}
