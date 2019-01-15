package com.persistence.jpahibernate.model.user;

import lombok.Data;

@Data
public class UserWebDto {

    private String firstName;
    private String lastName;
    private String email;
    private Integer languageId;
}
