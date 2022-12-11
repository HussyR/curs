package com.example.final_project.service;

import com.example.final_project.model.Poll;
import com.example.final_project.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PollServiceImpl implements PollService {

    private final PollRepository pollRepository;

    @Autowired
    public PollServiceImpl(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    @Override
    public void savePoll(Poll poll) {
        pollRepository.deleteAll();
        pollRepository.save(poll);
    }

    @Override
    public Poll getPollByName(String name) {
        return pollRepository.findByName(name);
    }
}
