package com.sdsxer.mmdiary.cache;

import com.sdsxer.mmdiary.domain.User;
import com.sdsxer.mmdiary.repository.UserRepository;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@CacheConfig(cacheNames = {"user"})
@Repository
public class UserCacheManager implements CacheManager<Long, User> {

    private final UserRepository userRepository;

    public UserCacheManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @CachePut(key = "#p0")
    @Override
    public void put(Long id, User user) {

    }

    @Cacheable(key = "#p0")
    @Override
    public User get(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.isPresent() ? userOptional.get() : null;
    }

    @CacheEvict(key = "#p0")
    @Override
    public void delete(Long id) {

    }
}