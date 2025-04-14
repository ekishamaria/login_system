package com.bpo.jiffy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bpo.jiffy.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}