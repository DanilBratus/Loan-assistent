package ru.project.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/loan_assistant", consumes = MediaType.ALL_VALUE)
public class UserController {
    @Value("${program.author.name}")
    private String authorName;

    @GetMapping()
    public ModelAndView start() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/hello.jsp");
        return modelAndView;
    }

    @GetMapping("/exit")
    public ModelAndView exit() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/goodbye.jsp");
        modelAndView.addObject("author", authorName);
        return modelAndView;
    }
}
