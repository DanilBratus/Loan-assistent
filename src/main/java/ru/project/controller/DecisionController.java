package ru.project.controller;

import com.sun.istack.NotNull;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.project.service.DecisionService;

import java.util.List;

@Controller
@RequestMapping(value = "/decision", consumes = MediaType.ALL_VALUE)
public class DecisionController {
    @NotNull
    private final DecisionService decisionService;

    public DecisionController(DecisionService decisionService) {
        this.decisionService = decisionService;
    }

    @PostMapping("/approve")
    public ModelAndView approve(@RequestParam("bankName") List<String> bankName) {
        List<String> decision = decisionService.decisionBank(bankName);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/decision.jsp");
        modelAndView.addObject("decision", decision);
        return modelAndView;
    }
}