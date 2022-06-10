package com.fullcycle.fccatalog.domain.repository;

import com.fullcycle.fccatalog.domain.entity.Category;

public interface ICategoryRepository {
  Iterable<Category> findAllCategories();
  Category create(Category toAdd);
}
