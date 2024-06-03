package com.daiane.starcatcherportfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daiane.starcatcherportfolio.models.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
  List<Project> findByUser_Id(Long id);
}
