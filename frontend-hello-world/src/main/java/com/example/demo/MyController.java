package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MyController {

    private List<String> surnames = new ArrayList<>();

    @RequestMapping("/index")
    public String viewHome(Map<String, Object> model) {
        model.put("now", LocalDate.now());
        model.put("message", "xxxx");

        surnames.forEach(s -> model.put("surname", s));
        return "index";
    }

    @RequestMapping("/register")
    public String handleRequest(Map<String, Object> model) {
        model.put("message", "yyy");
        return "index";
    }

    @GetMapping("/foo")
    public String showPage(Model model) {
        Object datePlanted = model.asMap().get("datePlanted");
        System.out.println("datePlanted = " + datePlanted);
        model.addAttribute("someBean", new SomeBean()); //assume SomeBean has a property called datePlanted
        return "foo";
    }

    @PostMapping("/foo")
    public String showPage(@ModelAttribute("someBean") SomeBean bean) {

        System.out.println("Date planted: " + bean.getDatePlanted()); //in reality, you'd use a logger instead :)
        return "redirect:index";
    }

    @PostMapping("multiple")
    public String addMultipleBean(@ModelAttribute("multipleBean") MultipleBean multipleBean) {
        surnames.add(multipleBean.getSurname());
        surnames.forEach(s -> System.out.println("s = " + s));
        return "redirect:index";
    }
}
