package com.daiane.starcatcherportfolio.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.daiane.starcatcherportfolio.models.User;
import com.daiane.starcatcherportfolio.models.User.createUser;
import com.daiane.starcatcherportfolio.models.User.updateUser;
import com.daiane.starcatcherportfolio.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/{id}")
  public ResponseEntity<User> findById(@PathVariable Long id) {
    User obj = this.userService.findById(id);
    return ResponseEntity.ok().body(obj);
  }

  @PostMapping
  @Validated(createUser.class)
  public ResponseEntity<Void> createUser(@Valid @RequestBody User obj) {
    this.userService.createUser(obj);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @PutMapping("/{id}")
  @Validated(updateUser.class)
  public ResponseEntity<Void> updateUser(@Valid @RequestBody User obj, @PathVariable Long id) {
    obj.setId(id);
    this.userService.updateUser(obj);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    this.userService.deleteUser(id);
    return ResponseEntity.noContent().build();
  }

}
