package com.daiane.starcatcherportfolio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daiane.starcatcherportfolio.models.Project;
import com.daiane.starcatcherportfolio.models.User;
import com.daiane.starcatcherportfolio.repository.ProjectRepository;

import jakarta.transaction.Transactional;

@Service
public class ProjectService {
  @Autowired
  private ProjectRepository projectRepository;

  @Autowired
  private UserService userService;

  public Project findById(Long id) {
    Optional<Project> project = this.projectRepository.findById(id);
    return project
        .orElseThrow(() -> new RuntimeException("Project not found! Id: " + id + ", Type: " + Project.class.getName()));
  }

  public List<Project> findAll() {
    List<Project> projects = this.projectRepository.findAll();
    return projects;
  }

  public List<Project> findByAllUserId(Long userId) {
    List<Project> projects = this.projectRepository.findByUser_Id(userId);
    return projects;
  }

  @Transactional
  public Project creaProject(Project obj) {
    User user = this.userService.findById(obj.getUser().getId());
    obj.setId(null);
    obj.setUser(user);
    obj = this.projectRepository.save(obj);
    return obj;
  }

  @Transactional
  public Project updateProject(Project obj) {
    Project newObj = this.findById(obj.getId());
    newObj.setTitle(obj.getTitle());
    newObj.setDescription(obj.getDescription());
    newObj.setUrlLink(obj.getUrlLink());
    return this.projectRepository.save(newObj);
  }

  public void deleteProject(Long id) {
    findById(id);
    this.projectRepository.deleteById(id);
  }
}
