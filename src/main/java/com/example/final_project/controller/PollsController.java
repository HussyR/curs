package com.example.final_project.controller;

import com.example.final_project.model.Answer;
import com.example.final_project.model.Poll;
import com.example.final_project.model.Question;
import com.example.final_project.model.User;
import com.example.final_project.service.PollService;
import com.example.final_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.security.core.Authentication;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PollsController {

    private Authentication authentication;
    private final UserService userService;
    private final PollService pollService;

    @Autowired
    public PollsController(UserService userService, PollService pollService) {
        this.userService = userService;
        this.pollService = pollService;
    }

    @ResponseBody
    @RequestMapping(value = "/pollCreated")
    public String getSearchResultViaAjax(@RequestParam(value="array[]") List<String> array)
    {
        Poll poll = new Poll();
        poll.setName("Poll");

        List<Question> questions = new ArrayList<Question>();
        for (String str:
             array) {
            Question question = new Question();
            question.setText(str);
            question.setPoll(poll);
            questions.add(question);
        }
        poll.setQuestions(questions);
        pollService.savePoll(poll);
        return "";
    }

    @ResponseBody
    @RequestMapping(value = "/closePoll")
    public String closePoll(@RequestParam(value="array[]") List<String> array)
    {
        authentication = authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = userService.getUserByEmail(email);

        Poll poll = pollService.getPollByName("Poll");
        List<Question> questions = poll.getQuestions();
        for (int i = 0; i < array.size(); i++) {
            String strAnswer = array.get(i);
            Question question = questions.get(i);

            Answer answer = new Answer();
            answer.setText(strAnswer);
            answer.setQuestion(question);
            answer.setUser(user);

            List<Answer> prAnswers = question.getAnswers();
            if (!prAnswers.isEmpty()) {
                prAnswers.add(answer);
                question.setAnswers(prAnswers);
            } else {
                List<Answer> rAnswers = new ArrayList<Answer>();
                rAnswers.add(answer);
                question.setAnswers(rAnswers);
            }
            questions.set(i, question);
        }
        poll.setQuestions(questions);
        pollService.savePoll(poll);
        return "";
    }
}
