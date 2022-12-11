package com.example.final_project.controller;

import com.example.final_project.dto.UserRegistrationDto;
import com.example.final_project.model.Poll;
import com.example.final_project.model.Question;
import com.example.final_project.model.User;
import com.example.final_project.service.PollService;
import com.example.final_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private final UserService userService;
    private final PollService pollService;

    @Autowired
    public MainController(UserService userService, PollService pollService) {
        this.userService = userService;
        this.pollService = pollService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String getRegistration(Model model) {
        UserRegistrationDto user = new UserRegistrationDto();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/registration")
    public String makeRegistration(@ModelAttribute("user") UserRegistrationDto user) {
        userService.save(user);
        return "redirect:/registration?success";
    }

    @GetMapping("/")
    public String home() {
        return "admin_index";
    }

    @GetMapping("/createPoll")
    public String createPoll() {
        return "create_poll";
    }

    @GetMapping("/get_all_questions")
    public String getAllQuestions(Model model) {
        Poll poll = pollService.getPollByName("Poll");
        model.addAttribute("list", poll.getQuestions());
        return "get_all_questions";
    }

    @GetMapping("/get_all_answers")
    public String getAllAnswers(Model model) {
        Poll poll = pollService.getPollByName("Poll");
        model.addAttribute("list", poll.getQuestions());
        return "get_all_answers";
    }

}
