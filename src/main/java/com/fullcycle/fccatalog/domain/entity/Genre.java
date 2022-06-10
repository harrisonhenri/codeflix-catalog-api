package com.fullcycle.fccatalog.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Genre extends BaseEntity {
  private String name;
  private List<Category> categories = new ArrayList<>();

  public Genre(String name){
    super.generateUUID();
    this.setName(name);
  }
  public Genre(UUID id){
    super.setId(id);
  }
  public Genre(UUID id, String name){
    super.setId(id);
    this.setName(name);
  }
  public Genre(String name, List<Category> categories){
    super.generateUUID();
    this.setName(name);
    this.setCategories(categories);
  }
  public Genre(UUID id, String name, List<Category> categories){
    super.setId(id);
    this.setName(name);
    this.setCategories(categories);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (name == null || name.length() == 0) throw new IllegalArgumentException("name is marked as non-null/non-empty but is null/empty");
    this.name = name;
  }

  public List<Category> getCategories() {
    return categories;
  }

  public void setCategories(List<Category> categories) {
    if (categories == null) throw new IllegalArgumentException("categories is marked as non-null but is null");
    this.categories = categories;
  }

  public void addCategory(Category category) {
    if (category == null) throw new IllegalArgumentException("category is marked as non-null but is null");
    this.categories.add(category);
  }

  public void removeCategory(Category category) {
    if (category == null) throw new IllegalArgumentException("category is marked as non-null but is null");
    this.categories.removeIf(c -> c.equals(category));
  }
}
