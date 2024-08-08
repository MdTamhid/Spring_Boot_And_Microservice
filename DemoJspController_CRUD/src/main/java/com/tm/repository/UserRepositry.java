package com.tm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tm.entity.UserEntity;

public interface UserRepositry extends JpaRepository<UserEntity, Integer>{

}
