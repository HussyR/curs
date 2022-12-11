package com.example.final_project.repository;

import com.example.final_project.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Poll, Long> {
    Poll findByName(String name);
}
