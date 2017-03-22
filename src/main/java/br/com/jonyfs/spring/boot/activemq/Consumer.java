/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonyfs.spring.boot.activemq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

    @JmsListener(destination = "${queueName}")
    public void receiveQueue(String text) {
        //System.out.println(text);
        LOGGER.info(text);
    }

}
