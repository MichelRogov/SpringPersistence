package com.persistence.jpahibernate.repository;

import com.persistence.jpahibernate.model.user.UserInfoWebResponse;

public interface UserAccountRepositoryCustom {

    UserInfoWebResponse getUserInfoByEmailCustom (String email);
}
