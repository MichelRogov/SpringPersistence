package com.persistence.jpahibernate.service;

import com.persistence.jpahibernate.model.user.UserInfoWebResponse;
import com.persistence.jpahibernate.model.user.UserWebDto;

public interface UserService {

    void createUser (UserWebDto user);

    UserInfoWebResponse findUserAccountByEmail(String email);
}
