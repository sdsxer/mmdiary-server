package com.sdsxer.mmdiary.security;

import com.sdsxer.mmdiary.domain.User;
import com.sdsxer.mmdiary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class RestUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByAccount(username);
        if(user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new RestUserDetails(user);
    }
}
