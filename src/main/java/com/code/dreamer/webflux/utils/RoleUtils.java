package com.code.dreamer.webflux.utils;

import com.code.dreamer.webflux.domain.Role;

import java.util.Objects;
import java.util.function.Predicate;

public class RoleUtils {
    public final static class Constants {
        public final static String ADMIN = "ADMIN";
        public final static String SUPER_ADMIN = "SUPER_ADMIN";
    }

    public static Predicate<Role> hasRole(String role) {
        return role1 -> Objects.equals(role1.getName(), role);
    }
}
