package com.example.final_project.repository;

import com.example.final_project.model.Poll;
import com.example.final_project.model.Question;
import com.example.final_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Question findByText(String text);
}
