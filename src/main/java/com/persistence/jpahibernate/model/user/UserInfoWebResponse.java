package com.persistence.jpahibernate.model.user;

import lombok.Data;

@Data
public class UserInfoWebResponse {

    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String languageDesc;
    private Integer accountStatus;

    public UserInfoWebResponse(Long userId, String firstName, String lastName, String email, String languageDesc, AccountStatus accountStatus) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.languageDesc = languageDesc;
        this.accountStatus = accountStatus.getId();
    }
}

