package com.sdsxer.mmdiary.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUtils {

    public static long getCurrentUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return 0;
    }
}
