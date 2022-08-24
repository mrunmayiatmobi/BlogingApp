package com.mrunmayi.blogapp.blogapp.repository;

import com.mrunmayi.blogapp.blogapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer>{
}
