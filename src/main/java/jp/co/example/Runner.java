package jp.co.example;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner {

  private final RabbitTemplate rabbitTemplate;
  private final Receiver receiver;

  public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
      this.receiver = receiver;
      this.rabbitTemplate = rabbitTemplate;
  }

  public void save() throws Exception {
      System.out.println("Sending message..." + Calendar.getInstance().getTime());
      rabbitTemplate.convertAndSend(App.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ!");
      receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
  }
}
