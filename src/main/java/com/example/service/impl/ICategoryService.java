package com.example.service.impl;

import com.example.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();
    Optional<Category> findById(Long id);
    Category save(Category category);
    void deleteById(Long id);
    List<Category> searchByCategoryName(String category);
}
