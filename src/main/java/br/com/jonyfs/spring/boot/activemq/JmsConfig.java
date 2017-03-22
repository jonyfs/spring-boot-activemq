package br.com.jonyfs.spring.boot.activemq;

import javax.jms.Queue;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JmsConfig {

    @Value("${queueName}")
    private String queueName;

    @Bean
    public Queue queue() {
        return new ActiveMQQueue(queueName);
    }
}
