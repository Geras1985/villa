package com.hotel.villa.repository;

import com.hotel.villa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findUserById(Long userId);
}
