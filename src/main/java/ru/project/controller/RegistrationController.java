package ru.project.controller;

import com.sun.istack.NotNull;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.project.model.User;
import ru.project.service.UserService;

@Controller
@RequestMapping(value = "/registration", consumes = MediaType.ALL_VALUE)
public class RegistrationController  {
    @NotNull
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/registration.jsp");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveUser(@ModelAttribute("user") User user) {
        if (userService.getUserByLogin(user.getLogin()) != null) {
            return new ModelAndView("/exception.jsp");
        }
        userService.saveUser(user);
        return new ModelAndView("redirect:/request");
    }
}