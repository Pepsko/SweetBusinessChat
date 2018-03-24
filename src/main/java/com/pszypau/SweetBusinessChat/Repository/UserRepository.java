package com.pszypau.SweetBusinessChat.Repository;

import com.pszypau.SweetBusinessChat.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Lenovo on 2018-03-24.
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByName(String name);
}
