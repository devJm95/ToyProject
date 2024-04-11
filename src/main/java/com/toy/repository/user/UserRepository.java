package com.toy.repository.user;

import com.toy.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String UserId);
    boolean existsByUserId(String userId);

    Optional<User> findUserByEmailAndProvider(String email, String provider);
}
