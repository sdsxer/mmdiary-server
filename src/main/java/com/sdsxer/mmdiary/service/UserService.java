package com.sdsxer.mmdiary.service;

import com.sdsxer.mmdiary.domain.User;
import com.sdsxer.mmdiary.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByAccount(String account) {
        return userRepository.getByUsername(account);
    }

    public User findUserByMobile(String mobile) {
        return userRepository.getByMobile(mobile);
    }
}
