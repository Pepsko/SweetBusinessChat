package com.pszypau.SweetBusinessChat.Service;

import com.pszypau.SweetBusinessChat.DTO.UserDTO;
import com.pszypau.SweetBusinessChat.Entity.UserEntity;
import com.pszypau.SweetBusinessChat.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder encoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.userMapper = userMapper;
    }

    public Set<UserDTO> getAllUsers(){
        return userRepository.findAll().stream()
                .map(userMapper::toUserDTO)
                .collect(Collectors.toSet());
    }
    public UserDTO findUserById(Integer id) {
        return userMapper.toUserDTO(userRepository.findOne(id));
    }

    public void saveUser(UserDTO user) {

        UserEntity userEntity = new UserEntity(user.getName(),user.getEmail(),encoder.encode(user.getPassword()),"USER");
        userRepository.save(userEntity);
    }

   /* public UserDTO findUserByEmail(String email) {
        return userMapper.toUserDTO(userRepository.findOneByEmail(email).orElseThrow(UserNotFoundException::new));
    }*/


}
