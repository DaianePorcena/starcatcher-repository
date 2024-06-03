package com.daiane.starcatcherportfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daiane.starcatcherportfolio.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
