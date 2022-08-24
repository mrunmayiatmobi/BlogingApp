package com.mrunmayi.blogapp.blogapp.mapper;

import com.mrunmayi.blogapp.blogapp.entities.User;
import com.mrunmayi.blogapp.blogapp.payloads.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserMapper {


    @Autowired
    private ModelMapper modelMapper;

    public UserDto mapUserToUserDto(User user){
//        UserDto userDto = new UserDto();
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setEmail(user.getEmail());
//        userDto.setPassword(user.getPassword());
//        userDto.setAbout(user.getPassword());
//        return userDto;

        return modelMapper.map(user,UserDto.class);
    }

    public User mapUserDtoToUser(UserDto userDto){
//        User user = new User();
//        user.setId(userDto.getId());
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//        user.setAbout(userDto.getPassword());
//        return user;
        return modelMapper.map(userDto,User.class);
    }
}
