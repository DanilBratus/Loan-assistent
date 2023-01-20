package ru.project.controller;

import com.sun.istack.NotNull;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.project.model.Request;
import ru.project.service.CompareService;

@Controller
@RequestMapping(value = "/compare", consumes = MediaType.ALL_VALUE)
public class CompareController {
    @NotNull
    private final CompareService compareService;

    public CompareController(CompareService compareService) {
        this.compareService = compareService;
    }

    @PostMapping("/submit")
    public ModelAndView compare(@ModelAttribute("request") Request request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/compare.jsp");
        modelAndView.addObject("compareList", compareService.compareCondition(request));
        return modelAndView;
    }
}
