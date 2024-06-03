package com.daiane.starcatcherportfolio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daiane.starcatcherportfolio.models.User;
import com.daiane.starcatcherportfolio.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public User findById(Long id) {
    Optional<User> user = this.userRepository.findById(id);
    return user
        .orElseThrow(() -> new RuntimeException("User not found! Id: " + id + ", Type: " + User.class.getName()));
  }

  @Transactional
  public User createUser(User obj) {
    obj.setId(null);
    obj = this.userRepository.save(obj);
    return obj;
  }

  @Transactional
  public User updateUser(User obj) {
    User newObj = this.findById(obj.getId());
    newObj.setPassword(obj.getPassword());
    return this.userRepository.save(newObj);
  }

  public void deleteUser(Long id) {
    findById(id);
    this.userRepository.deleteById(id);
  }
}
