package com.fullcycle.fccatalog.application.service;

import java.util.Optional;
import java.util.UUID;

import com.fullcycle.fccatalog.application.dto.CategoryDTO;
import com.fullcycle.fccatalog.domain.entity.Category;

public interface ICategoryService {
    Iterable<Category> findAll();
    Optional<Category> findById(UUID id);
    Category create(CategoryDTO toAdd);
}