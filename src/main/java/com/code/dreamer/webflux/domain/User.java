package com.code.dreamer.webflux.domain;

import com.code.dreamer.webflux.utils.RoleUtils;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

import static com.code.dreamer.webflux.utils.RoleUtils.Constants.ADMIN;
import static com.code.dreamer.webflux.utils.RoleUtils.Constants.SUPER_ADMIN;

@Data
@Accessors(chain = true)
public final class User {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private List<Role> roles = new ArrayList<>();

    public boolean isAdmin() {
        return this.roles.stream().anyMatch(RoleUtils.hasRole(ADMIN));
    }

    public boolean isSuperAdmin() {
        return this.roles.stream().anyMatch(RoleUtils.hasRole(SUPER_ADMIN));
    }

    public boolean hasRole(String role) {
        return this.roles.stream().anyMatch(RoleUtils.hasRole(role));
    }
}
