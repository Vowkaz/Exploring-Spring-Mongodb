package com.example.testemongo.resources;

import com.example.testemongo.domain.User;
import com.example.testemongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping( value = "/user")
public class UserResource
{
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>>findAll()
    {
        List<User> e = userService.findAll();
        return ResponseEntity.ok().body(e);
    }

}
