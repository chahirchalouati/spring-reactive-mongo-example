package com.code.dreamer.webflux.helper;

import com.code.dreamer.webflux.domain.Product;
import com.code.dreamer.webflux.domain.User;
import com.code.dreamer.webflux.response.ProductResponse;
import com.code.dreamer.webflux.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

import static com.code.dreamer.webflux.utils.ActionUtils.*;

@Component
@Slf4j
@RequiredArgsConstructor
public class DefaultActionHelperImpl implements ActionHelper {
    private final UserService userService;
    private final ModelMapper mapper;

    @Override
    public ProductResponse putAll(Product product) {
        final User currentUser = this.userService.getCurrentUser();
        final ProductResponse response = mapper.map(product, ProductResponse.class);
        fillActions(response, currentUser);
        return response;
    }

    private void fillActions(ProductResponse response, User currentUser) {
        response.getActions().put(DELETE_PRODUCT, shouldActivate(DELETE_PRODUCT, currentUser, User::isSuperAdmin));
        response.getActions().put(UPDATE_PRODUCT, shouldActivate(UPDATE_PRODUCT, currentUser, User::isSuperAdmin));
        response.getActions().put(ADD_COLOR_PRODUCT, shouldActivate(ADD_COLOR_PRODUCT, currentUser, User::isSuperAdmin));
        response.getActions().put(DELETE_COLOR_PRODUCT, shouldActivate(DELETE_COLOR_PRODUCT, currentUser, User::isSuperAdmin));
        response.getActions().put(ADD_STYLE_PRODUCT, shouldActivate(ADD_STYLE_PRODUCT, currentUser, User::isSuperAdmin));
        response.getActions().put(DELETE_STYLE_PRODUCT, shouldActivate(DELETE_STYLE_PRODUCT, currentUser, User::isSuperAdmin));
    }

    private boolean shouldActivate(String role, User currentUser, Predicate<User> predicate) {
        return currentUser.hasRole(role) || predicate.test(currentUser);
    }
}
