package com.mrunmayi.blogapp.blogapp.repository;

import com.mrunmayi.blogapp.blogapp.entities.Category;
import com.mrunmayi.blogapp.blogapp.entities.Post;
import com.mrunmayi.blogapp.blogapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {

    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);

}
