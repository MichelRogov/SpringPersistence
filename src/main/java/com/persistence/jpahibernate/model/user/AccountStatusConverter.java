package com.persistence.jpahibernate.model.user;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class AccountStatusConverter implements AttributeConverter<AccountStatus, Integer> {


    @Override
    public Integer convertToDatabaseColumn(AccountStatus attribute) {
        return attribute == null ? null : attribute.getId();
    }

    @Override
    public AccountStatus convertToEntityAttribute(Integer dbData) {
        return dbData == null ? null : AccountStatus.findAccountStatusById(dbData);
    }
}
