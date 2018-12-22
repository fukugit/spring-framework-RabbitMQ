package jp.co.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) throws InterruptedException {
      Thread.sleep(5000);
      String now = "[" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) + "] ";
      System.out.println(now + "Received <" + message + ">");
      latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}