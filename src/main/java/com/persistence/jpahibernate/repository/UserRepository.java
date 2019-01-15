package com.persistence.jpahibernate.repository;

import com.persistence.jpahibernate.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
