package com.daiane.starcatcherportfolio.controllers;

import java.net.URI;
import java.util.List;

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

import com.daiane.starcatcherportfolio.models.Project;
import com.daiane.starcatcherportfolio.services.ProjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/project")
@Validated
public class ProjectController {

  @Autowired
  private ProjectService projectService;

  @GetMapping("/{id}")
  public ResponseEntity<Project> findById(@PathVariable Long id) {
    Project obj = this.projectService.findById(id);
    return ResponseEntity.ok().body(obj);
  }

  @GetMapping("/user/{userId}")
  public ResponseEntity<List<Project>> findAllById(@PathVariable Long userId) {
    List<Project> projects = this.projectService.findByAllUserId(userId);
    return ResponseEntity.ok().body(projects);
  }

  @GetMapping("/all")
  public ResponseEntity<List<Project>> findAll() {
    List<Project> projects = this.projectService.findAll();
    return ResponseEntity.ok().body(projects);
  }

  @PostMapping
  @Validated
  public ResponseEntity<Void> createProject(@Valid @RequestBody Project obj) {
    this.projectService.creaProject(obj);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @PutMapping("/{id}")
  @Validated
  public ResponseEntity<Void> updateProject(@Valid @RequestBody Project obj, @PathVariable Long id) {
    obj.setId(id);
    this.projectService.updateProject(obj);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
    this.projectService.deleteProject(id);
    return ResponseEntity.noContent().build();
  }

}
