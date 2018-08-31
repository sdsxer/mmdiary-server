package com.sdsxer.mmdiary.service;

import com.sdsxer.mmdiary.domain.User;
import com.sdsxer.mmdiary.repository.UserRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findUserByMobile(String mobile) {
        return userRepository.findByMobile(mobile);
    }
}
