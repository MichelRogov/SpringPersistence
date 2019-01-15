package com.persistence.jpahibernate.repository;


import com.persistence.jpahibernate.model.user.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

}
