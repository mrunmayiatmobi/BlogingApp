package com.mrunmayi.blogapp.blogapp.controller;

import com.mrunmayi.blogapp.blogapp.payloads.CategoryDto;
import com.mrunmayi.blogapp.blogapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        return new ResponseEntity<CategoryDto>(this.categoryService.createCategory(categoryDto),HttpStatus.CREATED);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId){
        return new ResponseEntity<CategoryDto>(this.categoryService.getCategoryById(categoryId),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
        return new ResponseEntity<List<CategoryDto>>(this.categoryService.getAllCategory(),HttpStatus.OK);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Integer categoryId,@RequestBody CategoryDto categoryDto){
        return new ResponseEntity<CategoryDto>(this.categoryService.updateCategory(categoryDto,categoryId),HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<String> DeleteCategory(@PathVariable Integer categoryId){
        this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity<String>("Category Successfully Deleted",HttpStatus.OK);
    }
}
