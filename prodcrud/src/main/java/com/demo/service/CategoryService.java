package com.demo.service;

import java.util.List;
import java.util.Optional;

import com.demo.entity.Category;

public interface CategoryService {
	Category createCategory(Category category);
	Category getCategoryById(Integer id);
    List<Category> getAllCategory();
    void deleteCategory(Integer id);
    Optional<Category> updateCategory(Category category,Integer id);
}
