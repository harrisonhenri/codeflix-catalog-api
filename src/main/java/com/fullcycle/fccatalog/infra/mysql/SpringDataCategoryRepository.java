package com.fullcycle.fccatalog.infra.mysql;

import java.util.UUID;

import com.fullcycle.fccatalog.domain.entity.Category;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface SpringDataCategoryRepository extends PagingAndSortingRepository<Category, UUID> {
  
}
