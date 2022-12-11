package com.example.final_project.service;

import com.example.final_project.model.Poll;

public interface PollService {
    void savePoll(Poll poll);
    Poll getPollByName(String name);
}
