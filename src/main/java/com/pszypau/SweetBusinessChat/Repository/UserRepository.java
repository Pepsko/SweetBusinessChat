package com.pszypau.SweetBusinessChat.Repository;

import com.pszypau.SweetBusinessChat.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Lenovo on 2018-03-24.
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
