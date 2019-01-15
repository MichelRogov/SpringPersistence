package com.persistence.jpahibernate.repository;

import com.persistence.jpahibernate.model.user.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
}
