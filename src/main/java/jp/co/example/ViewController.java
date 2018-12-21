package jp.co.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

  @Autowired
  private Runner runner;

  @RequestMapping("/")
  public String index(Model model) {
      return "index";
  }

  @RequestMapping("/complete")
  public String complete(Model model) throws Exception {
    runner.save();
    return "complete";
  }
}
