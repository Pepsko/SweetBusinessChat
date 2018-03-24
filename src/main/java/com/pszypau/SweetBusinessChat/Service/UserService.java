package com.pszypau.SweetBusinessChat.Service;

import com.pszypau.SweetBusinessChat.DTO.UserDTO;
import com.pszypau.SweetBusinessChat.Entity.UserEntity;
import com.pszypau.SweetBusinessChat.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder encoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.userMapper = userMapper;
        createSampleUser();
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

        UserEntity userEntity = new UserEntity(user.getUuid(), user.getName(),user.getEmail(),encoder.encode(user.getPassword()),"USER");
        userRepository.save(userEntity);
    }

    public User toUser(UserEntity entity){
        return new User(entity.getName(), entity.getPassword(), Collections.singletonList(new SimpleGrantedAuthority(entity.getRole())));
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return toUser(userRepository.findByName(username).orElseThrow(()-> new UsernameNotFoundException(username)));
    }

    private void createSampleUser(){
        if (!userRepository.findByName("user").isPresent()){
            UserEntity entity = new UserEntity("user", encoder.encode("password"),
                    "USER");
            userRepository.save(entity);
        }
    }
}
