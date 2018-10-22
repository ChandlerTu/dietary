package com.chandlertu.dietary;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DietaryController {

  @Autowired
  private DietaryRepository repository;

  @GetMapping("/dietary")
  public String dietaryForm(Model model) {
    model.addAttribute("dietary", new Dietary());
    model.addAttribute("dietaries", repository.findAll());
    return "dietary";
  }

  @PostMapping("/dietary")
  public String dietarySubmit(@ModelAttribute Dietary dietary, Model model) {
    if (!dietary.getFood().isEmpty()) {
      dietary.setInsertTime(new Date());
      repository.save(dietary);
    }
    model.addAttribute("dietaries", repository.findAll());
    return "dietary";
  }

}
