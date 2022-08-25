package com.mrunmayi.blogapp.blogapp.service.impl;

import com.mrunmayi.blogapp.blogapp.entities.Category;
import com.mrunmayi.blogapp.blogapp.expection.CategoryNotFoundException;
import com.mrunmayi.blogapp.blogapp.payloads.CategoryDto;
import com.mrunmayi.blogapp.blogapp.repository.CategoryRepo;
import com.mrunmayi.blogapp.blogapp.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    public CategoryRepo categoryRepo;

    @Autowired
    public ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        return this.modelMapper.map((categoryRepo.save(this.modelMapper.map(categoryDto, Category.class))), CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("Category", " Category Id", categoryId));
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());
        return this.modelMapper.map(categoryRepo.save(category), CategoryDto.class);
    }

    @Override
    public CategoryDto getCategoryById(Integer categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("Category", " Category Id", categoryId));
        return this.modelMapper.map(categoryRepo.save(category), CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categories = categoryRepo.findAll();
        return categories.stream().map(category -> this.modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("Category", " Category Id", categoryId));
        categoryRepo.delete(category);
    }
}
