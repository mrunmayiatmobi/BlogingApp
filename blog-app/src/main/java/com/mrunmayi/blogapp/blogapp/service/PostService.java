package com.mrunmayi.blogapp.blogapp.service;

import com.mrunmayi.blogapp.blogapp.entities.Post;
import com.mrunmayi.blogapp.blogapp.payloads.PostDto;

import java.util.List;

public interface PostService {

    //create
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    //update
    public PostDto updatePost(PostDto postDto, Integer postId);

    //get
    public PostDto getPost(Integer postId);

    //getAll
    public List<PostDto> getAllPost();

    //delete
    public void deletePost(Integer postId);

}
