package com.mrunmayi.blogapp.blogapp.service.impl;

import com.mrunmayi.blogapp.blogapp.entities.User;
import com.mrunmayi.blogapp.blogapp.expection.ResourceNotFoundException;
import com.mrunmayi.blogapp.blogapp.mapper.UserMapper;
import com.mrunmayi.blogapp.blogapp.payloads.UserDto;
import com.mrunmayi.blogapp.blogapp.repository.UserRepo;
import com.mrunmayi.blogapp.blogapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        return userMapper.mapUserToUserDto((User)this.userRepo.save(userMapper.mapUserDtoToUser(userDto)));
    }

    @Override
    public UserDto updateUser(UserDto userDto,Integer userId) {

        User user = this.userRepo.findById(userId).orElseThrow( () -> new ResourceNotFoundException("user","id",userId));
        user.setName(userDto.getName());

        User updateUser = this.userRepo.save(user);

        return userMapper.mapUserToUserDto(updateUser);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow( () -> new ResourceNotFoundException("user","id",userId));

        return userMapper.mapUserToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<User> userList = this.userRepo.findAll();
        return userList.stream().map(user -> userMapper.mapUserToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow( () -> new ResourceNotFoundException("user","id",userId));
        this.userRepo.delete(user);
    }
}
