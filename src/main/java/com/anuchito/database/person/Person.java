package com.anuchito.database.person;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
  @Id
  private Long id;

  @Column(name = "person_id", nullable = false, unique = true, length = 50)
  private String personId;

  @Column(name = "name", nullable = false, length = 255)
  private String name;

  @Column(name = "age", nullable = false)
  private Integer age;
}