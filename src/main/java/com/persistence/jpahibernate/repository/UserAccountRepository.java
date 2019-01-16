package com.persistence.jpahibernate.repository;


import com.persistence.jpahibernate.model.user.User;
import com.persistence.jpahibernate.model.user.UserAccount;
import com.persistence.jpahibernate.model.user.UserInfoWebResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long>, UserAccountRepositoryCustom {

    UserAccount findByUser(User user);

    @Query ("SELECT uc FROM UserAccount uc WHERE uc.user.email = :email")
    UserAccount findByUserEmail(@Param("email") String email);

    @Query ("SELECT new com.persistence.jpahibernate.model.user.UserInfoWebResponse" +
            "(uc.user.id, uc.user.firstName, uc.user.lastName, uc.user.email, uc.language.desc, uc.accountStatus)" +
            "FROM UserAccount uc WHERE uc.user.email = :email")
    UserInfoWebResponse getUserInfoByEmail(@Param("email") String email);

}
