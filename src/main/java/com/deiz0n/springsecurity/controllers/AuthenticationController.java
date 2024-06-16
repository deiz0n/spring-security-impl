package com.deiz0n.springsecurity.controllers;

import com.deiz0n.springsecurity.domain.dtos.AuthenticationDTO;
import com.deiz0n.springsecurity.domain.entities.User;
import com.deiz0n.springsecurity.domain.utils.TokenDTO;
import com.deiz0n.springsecurity.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO request) {
        var userPassword = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
        var auth = authenticationManager.authenticate(userPassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        System.out.println(auth.getPrincipal());

        return ResponseEntity.ok(new TokenDTO(token));
    }
}
