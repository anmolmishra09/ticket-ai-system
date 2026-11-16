package com.example.support.repository;

import com.example.support.entity.User;
import com.example.support.enums.UserRole;
import com.example.support.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    List<User> findByRoleAndStatus(
        UserRole role,
        UserStatus status
    );
}