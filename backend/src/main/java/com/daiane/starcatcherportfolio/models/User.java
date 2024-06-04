package com.daiane.starcatcherportfolio.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class User {

  public interface createUser {

  }

  public interface updateUser {

  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true)
  private Long id;

  @Column(name = "name", nullable = false, length = 100)
  @NotNull(groups = createUser.class)
  @NotEmpty(groups = createUser.class)
  private String name;

  @Column(name = "email", nullable = false, length = 100)
  @NotNull(groups = createUser.class)
  @NotEmpty(groups = createUser.class)
  private String email;

  @Column(name = "password", nullable = false, length = 60)
  @NotNull(groups = { createUser.class, updateUser.class })
  @NotEmpty(groups = { createUser.class, updateUser.class })
  @Size(groups = { createUser.class, updateUser.class }, min = 8, max = 60)
  private String password;

  @OneToMany(mappedBy = "user")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private List<Project> projects = new ArrayList<>();

}