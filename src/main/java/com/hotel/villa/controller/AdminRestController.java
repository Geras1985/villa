package com.hotel.villa.controller;

import com.hotel.villa.dto.UserDto;
import com.hotel.villa.entity.User;
import com.hotel.villa.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/admin")
public class AdminRestController {

        private final UserService userService;

        public AdminRestController(UserService userService) {
            this.userService = userService;
        }

        @GetMapping(value = "users/{id}")
        public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id) {
            User user = userService.findById(id);

            if (user == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            UserDto result = UserDto.fromUser(user);

            return new ResponseEntity<>(result, HttpStatus.OK);

    }
}
