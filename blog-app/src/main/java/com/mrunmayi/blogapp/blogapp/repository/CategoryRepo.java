package com.mrunmayi.blogapp.blogapp.repository;

import com.mrunmayi.blogapp.blogapp.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {

}
