package com.sdsxer.mmdiary.cache;

import com.sdsxer.mmdiary.domain.User;
import com.sdsxer.mmdiary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@CacheConfig(cacheNames = "users")
@Repository
public class UserCacheManager implements CacheManager<String, User> {

    @Autowired
    private UserRepository userRepository;

    @CachePut(key = "#username")
    @Override
    public User put(String username, User user) {
        return user;
    }

    @Cacheable(key = "#username")
    @Override
    public User get(String username) {
        return userRepository.findByUsername(username);
    }

    @CacheEvict(key = "#username")
    @Override
    public void delete(String username) {

    }
}