package com.persistence.jpahibernate.model.user;

import lombok.Data;

import java.util.Arrays;
import java.util.Optional;

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

    public static AccountStatus findAccountStatusById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID can not be null");
        }

        Optional<AccountStatus> accountStatus = Arrays.stream(AccountStatus.values()).filter(k -> k.getId().equals(id)).findFirst();

        return accountStatus.orElseThrow(() -> new IllegalArgumentException("Status not present"));
    }
}
