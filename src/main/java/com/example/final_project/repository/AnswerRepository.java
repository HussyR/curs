package com.example.final_project.repository;

import com.example.final_project.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Answer findByText(String text);
}
