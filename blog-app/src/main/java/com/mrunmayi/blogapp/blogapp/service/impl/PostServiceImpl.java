package com.mrunmayi.blogapp.blogapp.service.impl;

import com.mrunmayi.blogapp.blogapp.entities.Post;
import com.mrunmayi.blogapp.blogapp.expection.ResourceNotFoundException;
import com.mrunmayi.blogapp.blogapp.payloads.PostDto;
import com.mrunmayi.blogapp.blogapp.repository.PostRepo;
import com.mrunmayi.blogapp.blogapp.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        Post post = modelMapper.map(postDto, Post.class);
        Post createdPost = postRepo.save(post);
        return modelMapper.map(createdPost, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Ppst", "Post Id", postId));
        post.setTitle(postDto.getTitle());
            return null;
    }

    @Override
    public PostDto getPost(Integer postId) {
        return null;
    }

    @Override
    public List<PostDto> getAllPost() {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }
}
