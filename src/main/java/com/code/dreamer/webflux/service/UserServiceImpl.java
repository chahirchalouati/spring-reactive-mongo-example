package com.code.dreamer.webflux.service;

import com.code.dreamer.webflux.domain.User;
import com.code.dreamer.webflux.utils.UserUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getCurrentUser() {
        return UserUtils.buildAdminUser();
    }
}
