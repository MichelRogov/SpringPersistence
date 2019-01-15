package com.persistence.jpahibernate.model.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Language {

    @Id
    private Integer id;

    @Column(name = "DESC", nullable = false)
    private String desc;

}
