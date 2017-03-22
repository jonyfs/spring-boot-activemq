package br.com.jonyfs.spring.boot.activemq;

import javax.annotation.Resource;
import javax.jms.Queue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Producer implements CommandLineRunner {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Resource
    private Queue queue;

    @Override
    public void run(String... args) throws Exception {
        send("Sample message");
        LOGGER.info("Message was sent to the Queue");
    }

    public void send(String msg) {
        this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
    }
}
