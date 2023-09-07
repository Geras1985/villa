package com.hotel.villa.service;

import com.hotel.villa.entity.User;
import org.springframework.security.core.Authentication;

import java.util.List;


public interface UserService {

    User register(User user);

    List<User> getAll();

    User findByUsername(String username);

    User findById(Long id);

    void delete(Long id);

    User loggedInUser(Authentication auth);

}
