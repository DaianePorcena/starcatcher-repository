package com.daiane.starcatcherportfolio.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "project")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false, updatable = false)
  private User user;

  @Column(name = "title", nullable = false, length = 255)
  @NotNull
  @NotEmpty
  @Size(min = 3, max = 255)
  private String title;

  @Column(name = "description", nullable = false, length = 255)
  @NotNull
  @NotEmpty
  @Size(min = 3, max = 255)
  private String description;

  @Column(name = "url_link", nullable = false)
  @NotNull
  @NotEmpty
  private String urlLink;

}
