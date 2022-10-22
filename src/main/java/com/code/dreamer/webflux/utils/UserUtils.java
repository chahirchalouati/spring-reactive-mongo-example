package com.code.dreamer.webflux.utils;

import com.code.dreamer.webflux.domain.Role;
import com.code.dreamer.webflux.domain.User;

import java.util.List;

import static com.code.dreamer.webflux.utils.RoleUtils.Constants.ADMIN;

public class UserUtils {
    public static User buildAdminUser() {
        return new User()
                .setUserName("username")
                .setFirstName("username")
                .setLastName("username")
                .setEmail("username")
                .setPassword("username")
                .setRoles(List.of(new Role().setName(ADMIN)));
    }
}
