package com.fullcycle.fccatalog.domain.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;

@Entity
@Table(name = "categories")
@EqualsAndHashCode
public class Category extends BaseEntity {
  
  @Column
  private String name;

  private Category(){}

  public Category(String name){
    super.generateUUID();
    this.setName(name);
  }
  public Category(UUID id){
    super.setId(id);
  }
  public Category(UUID id, String name){
    super.setId(id);
    this.setName(name);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (name == null || name.length() == 0) throw new IllegalArgumentException("name is marked as non-null/non-empty but is null/empty");
    this.name = name;
  }
}
