package com.example.bootdemo.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User, Long>,JpaSpecificationExecutor {

    User findByUserName(String userName);

    User findByUserNameOrEmail(String username, String email);
}