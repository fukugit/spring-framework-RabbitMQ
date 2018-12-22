package jp.co.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Producer {

  private final RabbitTemplate rabbitTemplate;
  private final Consumer receiver;

  public Producer(Consumer receiver, RabbitTemplate rabbitTemplate) {
    this.receiver = receiver;
    this.rabbitTemplate = rabbitTemplate;
  }

  public void save(String message) throws Exception {
    String now = "[" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) + "] ";
    System.out.println(now + "Sending message : " + message);
    rabbitTemplate.convertAndSend(App.topicExchangeName, "foo.bar.baz", message);
    receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
  }
}
