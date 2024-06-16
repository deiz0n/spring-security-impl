package com.deiz0n.springsecurity.controllers;

import com.deiz0n.springsecurity.domain.dtos.UserDTO;
import com.deiz0n.springsecurity.domain.entities.User;
import com.deiz0n.springsecurity.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UserDTO> createUser(@RequestBody User request) {
        var user = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
