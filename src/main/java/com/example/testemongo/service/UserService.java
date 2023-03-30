package com.example.testemongo.service;

import com.example.testemongo.domain.User;
import com.example.testemongo.dto.UserDTO;
import com.example.testemongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(String id)
    {
        Optional<User> e = userRepository.findById  (id);
        if (e.isEmpty())
        {
            throw new RuntimeException("Usuario não encontrado");
        }
        return e;
    }

    public User insert(User e )
    {
        return userRepository.insert(e);
    }

    public void delete(String id)
    {
        findById(id);
        userRepository.deleteById(id);
    }

    public User fromDTO(UserDTO e)
    {
        return new User(e.getId(), e.getName(), e.getEmail());
    }


}
