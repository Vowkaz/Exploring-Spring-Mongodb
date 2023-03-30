package com.example.testemongo.dto;

import com.example.testemongo.domain.User;

import java.io.Serial;
import java.io.Serializable;
import java.util.Optional;

public class UserDTO implements Serializable
{
    @Serial
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String email;

    public UserDTO(){}

    public UserDTO(User e)
    {
        id = e.getId();
        name = e.getName();
        email = e.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
