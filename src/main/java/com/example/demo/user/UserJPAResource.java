package com.example.demo.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.jpa.UserRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserJPAResource {

    private UserRepository repository;

    public UserJPAResource(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public User retrieveUser(@PathVariable Integer id) {
        Optional<User> user = repository.findById(id);

        if (user.isEmpty()) {
            throw new UserNotFoundException("id: " + id);
        }
        return user.get();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = repository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
