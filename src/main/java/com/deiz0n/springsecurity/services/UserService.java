package com.deiz0n.springsecurity.services;

import com.deiz0n.springsecurity.domain.dtos.UserDTO;
import com.deiz0n.springsecurity.domain.entities.User;
import com.deiz0n.springsecurity.domain.exceptions.UserExistingException;
import com.deiz0n.springsecurity.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository repository;
    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(user -> new UserDTO(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getRole()))
                .toList();
    }

    public UserDTO create(User request) {
        if (repository.findByEmail(request.getEmail()) != null)
            throw new UserExistingException("User already exists");

        request.setPassword(passwordEncoder.encode(request.getPassword()));

        var user = repository.save(request);

        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole());
    }
}
