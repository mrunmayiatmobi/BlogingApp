package com.mrunmayi.blogapp.blogapp.service;

import com.mrunmayi.blogapp.blogapp.payloads.UserDto;

import java.util.List;

public interface UserService {

    //Create user

    public UserDto createUser(UserDto user);
    public UserDto updateUser(UserDto user, Integer userId);
    public UserDto getUserById(Integer userId);
    public List<UserDto> getAllUsers();
    public void deleteUser(Integer userId);
}
