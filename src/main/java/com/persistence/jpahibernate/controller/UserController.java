package com.persistence.jpahibernate.controller;

import com.persistence.jpahibernate.model.user.UserInfoWebResponse;
import com.persistence.jpahibernate.model.user.UserWebDto;
import com.persistence.jpahibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PutMapping("/user/create")
    public void createUser(@RequestBody UserWebDto userWebDto) {
        userService.createUser(userWebDto);
    }

    @GetMapping("/user/by/{email}")
    public UserInfoWebResponse getUserInfoByEmail(@PathVariable String email) {
        return userService.findUserAccountByEmail(email);
    }
}
