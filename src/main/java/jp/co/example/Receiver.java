package jp.co.example;

import java.util.Calendar;
import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) throws InterruptedException {
      Thread.sleep(5000);
      System.out.println("Received <" + message + ">" + Calendar.getInstance().getTime());
      latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}