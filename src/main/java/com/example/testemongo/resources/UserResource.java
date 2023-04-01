package com.example.testemongo.resources;

import com.example.testemongo.domain.User;
import com.example.testemongo.dto.UserDTO;
import com.example.testemongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping( value = "/user")
public class UserResource
{
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>>findAll()
    {
        List<User> e = userService.findAll();
        List<UserDTO> l = e.stream().map(i-> new UserDTO(i)).collect(Collectors.toList());
        return ResponseEntity.ok().body(l);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable String id)
    {
        Optional<User> e = userService.findById(id);
        return ResponseEntity.ok().body(e);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO e)
    {
        User o = userService.fromDTO(e);
        o = userService.insert(o);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(o.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping( value = "/{id}")
    public ResponseEntity<User> update(@PathVariable String id,@RequestBody User e)
    {
        e = userService.update(id, e);
        return ResponseEntity.ok(e);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id)
    {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
