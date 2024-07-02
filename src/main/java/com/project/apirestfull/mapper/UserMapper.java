package com.project.apirestfull.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
	
import com.project.apirestfull.dto.UserDto;
import com.project.apirestfull.models.UserModel;

@Component
public class UserMapper implements GenericMapper<UserDto, UserModel> {
    
    @Autowired
    private ModelMapper mapper;

    @Override
    public UserModel toEntity(UserDto dtoUser) {
        return mapper.map(dtoUser, UserModel.class);
    }

    @Override
    public UserDto toDto(UserModel user) {
        return mapper.map(user, UserDto.class);
    }
}

