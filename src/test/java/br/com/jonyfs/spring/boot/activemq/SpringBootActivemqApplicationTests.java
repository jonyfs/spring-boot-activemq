package br.com.jonyfs.spring.boot.activemq;

import javax.annotation.Resource;
import javax.jms.JMSException;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootActivemqApplicationTests {

    @Resource
    ApplicationContext applicationContext;

    @Autowired
    private Producer producer;

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void contextLoads() {
        assertThat(applicationContext).isNotNull();
    }

    @Test
    public void sendSimpleMessage() throws InterruptedException, JMSException {
        this.producer.send("Test message");
        Thread.sleep(1000L);
        assertThat(this.outputCapture.toString().contains("Test message")).isTrue();
    }

}
