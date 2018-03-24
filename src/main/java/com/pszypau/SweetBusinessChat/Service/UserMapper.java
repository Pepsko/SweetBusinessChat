package com.pszypau.SweetBusinessChat.Service;

import com.pszypau.SweetBusinessChat.DTO.UserDTO;
import com.pszypau.SweetBusinessChat.Entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toUserEntity(UserDTO userDTO);
    UserDTO toUserDTO(UserEntity userEntity);
}
