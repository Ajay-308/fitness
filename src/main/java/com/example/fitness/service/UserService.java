package com.example.fitness.service;

import com.example.fitness.model.User;
import com.example.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User register(User user){
        return userRepository.save(user);
    }

    public User login(String email,String password){
        User user = userRepository.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("Invalid email or password"));
        if(!user.getPassword().equals(password)){
            throw new RuntimeException("Invalid email or password");
        }
        return user;
    }
}