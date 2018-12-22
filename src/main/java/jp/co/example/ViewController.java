package jp.co.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

  @Autowired
  private Producer producer;

  @RequestMapping("/")
  public String index(Model model) {
      return "index";
  }

  @GetMapping("/complete")
  public String complete(Model model, @RequestParam("message") String message) throws Exception {
    producer.save(message);
    return "complete";
  }
}
