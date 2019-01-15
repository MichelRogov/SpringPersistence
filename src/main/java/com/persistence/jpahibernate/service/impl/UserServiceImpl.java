package com.persistence.jpahibernate.service.impl;

import com.persistence.jpahibernate.model.user.*;
import com.persistence.jpahibernate.repository.LanguageRepository;
import com.persistence.jpahibernate.repository.UserAccountRepository;
import com.persistence.jpahibernate.repository.UserRepository;
import com.persistence.jpahibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final static Integer DEFAULT_LANGUAGE = 1;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    LanguageRepository languageRepository;

    @Override
    public void createUser(UserWebDto userWeb) {
        User user = saveUser(userWeb);
        saveUserAccount(user, userWeb);
    }

    private User saveUser(UserWebDto userWebDto) {
        User user = new User();
        user.setFirstName(userWebDto.getFirstName());
        user.setLastName(userWebDto.getLastName());
        user.setEmail(userWebDto.getEmail());
        userRepository.save(user);

        return user;
    }

    private void saveUserAccount(User user, UserWebDto userWebDto) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUser(user);
        userAccount.setStatusId(AccountStatus.NEW.getId());

        Optional<Language> optionalLanguage = languageRepository.findById(userWebDto.getLanguageId());
        if (!optionalLanguage.isPresent()){
            optionalLanguage = languageRepository.findById(DEFAULT_LANGUAGE);
        }

        userAccount.setLanguage(optionalLanguage.get());
        userAccountRepository.save(userAccount);
    }
}
