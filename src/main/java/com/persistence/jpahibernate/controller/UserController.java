package com.persistence.jpahibernate.controller;

import com.persistence.jpahibernate.model.user.UserWebDto;
import com.persistence.jpahibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PutMapping("/user/create")
    public void createUser(@RequestBody UserWebDto userWebDto) {
        userService.createUser(userWebDto);
    }
}
