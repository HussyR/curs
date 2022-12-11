package com.example.final_project.service;

import com.example.final_project.dto.UserRegistrationDto;
import com.example.final_project.model.Poll;
import com.example.final_project.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService {
    User save(UserRegistrationDto user);
    User getUserByEmail(String email);
}
