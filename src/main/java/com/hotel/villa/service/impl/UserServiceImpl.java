package com.hotel.villa.service.impl;

import com.hotel.villa.dto.UserLoginDto;
import com.hotel.villa.entity.Role;
import com.hotel.villa.entity.User;
import com.hotel.villa.model.Status;
import com.hotel.villa.repository.RoleRepo;
import com.hotel.villa.repository.UserRepo;
import com.hotel.villa.service.UserService;
import com.hotel.villa.util.Helper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;


    @Autowired
    public UserServiceImpl(UserRepo userRepo, RoleRepo roleRepo, BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;

    }

    @Override
    public User register(User user) {
        Role role = roleRepo.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(role);

        user.setPassword(Helper.passwordEncoder(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);

        User registerUser = userRepo.save(user);

        log.info("IN register - user: {} successfully registered", registerUser);

        return registerUser;
    }

    @Override
    public List<User> getAll() {
        List<User> result = userRepo.findAll();

        log.info("IN getAll - {} users found", result.size());

        return result;
    }

    @Override
    public User findByUsername(String username) {
        User result = userRepo.findByUsername(username);

        log.info("IN findByUsername - user: {} found by username: {}", result, username);

        return result;
    }

    @Override
    public User findById(Long id) {
        User result = userRepo.findById(id).orElse(null);

        if (result == null) {
            log.info("IN findById - no user found by id: {}", id);
            return null;
        }
        log.info("IN findById - user: {} found by id:", result);
        return null;
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
        log.info("IN delete - user with id: {} successfully was deleted", id);

    }

    @Override
    public User loggedInUser(Authentication authentication) {

        String username = ((org.springframework.security.core.userdetails.User) authentication.getPrincipal()).getUsername();
        log.info("IN logged username - {} ", username);
        return userRepo.findByUsername(username);
    }

    public User loginUser(UserLoginDto userLoginDto) {
        User user;
        if (userLoginDto.getUsername() != null && userLoginDto.getPassword() != null) {
            user = userRepo.findByUsername(userLoginDto.getUsername());
            if (user != null) {
                String pass = Helper.passwordEncoder(userLoginDto.
                        getPassword());

                if (BCrypt.checkpw(user.getPassword(), pass)) {
                    return user;
                }
            }
        }
        return null;
    }

    public User changhePass(UserLoginDto userLoginDto,String newPass) {
        User user;
        if (userLoginDto.getUsername() != null && userLoginDto.getPassword() != null) {
            user = userRepo.findByUsername(userLoginDto.getUsername());
            if (user != null) {
                String pass = Helper.passwordEncoder(userLoginDto.getPassword());

                if (BCrypt.checkpw(user.getPassword(), pass)) {
                    user.setPassword(Helper.passwordEncoder(newPass));
                   user=userRepo.save(user);
                    return user;
                }
            }
        }
        return null;
    }
}