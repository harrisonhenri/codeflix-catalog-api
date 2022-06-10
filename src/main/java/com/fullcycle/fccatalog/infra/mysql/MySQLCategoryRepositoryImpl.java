package com.fullcycle.fccatalog.infra.mysql;

import com.fullcycle.fccatalog.domain.entity.Category;
import com.fullcycle.fccatalog.domain.repository.ICategoryRepository;

import org.springframework.stereotype.Repository;

@Repository
public class MySQLCategoryRepositoryImpl implements ICategoryRepository {

  private SpringDataCategoryRepository repository;

  public MySQLCategoryRepositoryImpl(SpringDataCategoryRepository repository){
    this.repository = repository;
  }

  @Override
  public Iterable<Category> findAllCategories() {
    return this.repository.findAll();
  }

  @Override
  public Category create(Category toAdd) {
      return this.repository.save(toAdd);
  }

}
