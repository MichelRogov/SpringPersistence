package com.persistence.jpahibernate.service;

import com.persistence.jpahibernate.model.user.UserWebDto;

public interface UserService {

    void createUser (UserWebDto user);
}
