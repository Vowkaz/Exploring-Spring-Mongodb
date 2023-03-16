package com.example.testemongo.service;

import com.example.testemongo.domain.User;
import com.example.testemongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;
    public List<User> findAll()
    {
        return userRepository.findAll();
    }
}
