package com.example.delivery.mappers;

import com.example.delivery.domain.User;
import com.example.delivery.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDTO(User user);

    List<UserDTO> UsersToUsersDTO(List<User> users);
}
