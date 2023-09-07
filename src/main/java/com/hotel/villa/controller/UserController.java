package com.hotel.villa.controller;

import com.hotel.villa.dto.UserDto;
import com.hotel.villa.dto.UserLoginDto;
import com.hotel.villa.entity.Card;
import com.hotel.villa.entity.User;
import com.hotel.villa.service.UserService;
import com.hotel.villa.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@RequestMapping(value = "/api/v1/users")
@EnableWebMvc
@Api(description = "how to work in swagger")
public class UserController {
    private final UserServiceImpl userServiceImpl;


    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping(value = "{id}")
    @ApiOperation("GET user by Id")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id){
        User user = userServiceImpl.findById(id);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        UserDto result = UserDto.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/user_login")

    public User userLogin(@RequestBody UserLoginDto userLoginDto) {
        return userServiceImpl.loginUser(userLoginDto);
    }

    @PostMapping("/add_user")
    @ApiOperation("ADD user by Id")
    public ResponseEntity<User> addUser(@RequestBody UserDto userDto) {
        User user1 = new User();
        user1.setUsername(userDto.getUsername());
        user1.setEmail(userDto.getEmail());
        user1.setFirstName(userDto.getFirstName());
        user1.setLastName(userDto.getLastName());
        user1.setPassword(userDto.getPassword());
       // user1.setAddress(userDto.getAddress);
        userServiceImpl.register(user1);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

//    @DeleteMapping("/delete")
//   // @ApiOperation("DELETE user by Id")
//    public ResponseEntity<String> deleteCard(Long id){
//        if (id!=null){
//            User user = userService.findById(id);
//            if (user!=null) {
//                userService.delete(id);
//            }return new ResponseEntity<>("The card was deleted successfully", HttpStatus.OK);
//        }
//
//        return new ResponseEntity<>("This ID card was not found", HttpStatus.NOT_FOUND);
//    }
    //TODO validation, encoding password
}
