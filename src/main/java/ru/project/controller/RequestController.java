package ru.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.project.model.Request;

@Controller
@RequestMapping("/request")
public class RequestController {

    @GetMapping()
    public ModelAndView request() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/request.jsp");
        modelAndView.addObject("request", new Request());
        return modelAndView;
    }
}
