package com.example.testemongo.resources;

import com.example.testemongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping( value = "/user")
public class UserResource
{
    @GetMapping
    public ResponseEntity<List<User>>findAll()
    {
        User e1 = new User(1,"Jhon Brown", "jhon@mail.com");
        User e2 = new User(2,"Jhon Brown", "jhon@mail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(e2,e1));
        return ResponseEntity.ok().body(list);
    }

}
