package com.persistence.jpahibernate.repository.impl;

import com.persistence.jpahibernate.model.user.UserInfoWebResponse;
import com.persistence.jpahibernate.repository.UserAccountRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserAccountRepositoryCustomImpl implements UserAccountRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserInfoWebResponse getUserInfoByEmailCustom(String email) {

        StringBuilder query = new StringBuilder()
                .append("SELECT new com.persistence.jpahibernate.model.user.UserInfoWebResponse")
                .append("(u.id, u.firstName, u.lastName, u.email, uc.language.desc, uc.accountStatus)")
                .append("FROM UserAccount uc join uc.user u WHERE u.id = uc.user.id AND uc.user.email = :email");

        return (UserInfoWebResponse) entityManager.createQuery(query.toString())
                .setParameter("email", email)
                .getSingleResult();
    }
}
