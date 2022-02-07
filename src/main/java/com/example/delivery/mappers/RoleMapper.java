package com.example.delivery.mappers;

import com.example.delivery.domain.Role;
import com.example.delivery.dto.RoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    List<RoleDTO> RolesToRoleDTO(List<Role> roles);

}
