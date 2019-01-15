package com.persistence.jpahibernate.model.user;

import lombok.Data;

public enum AccountStatus {
    NEW(1),
    CONFIRMED(2);

    private Integer id;

    AccountStatus(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
