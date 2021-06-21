package com.javaee.bookshop_user_provider.serviceInterface;

import com.javaee.bookshop_user_provider.entity.User;

public interface UserService {
    void add(User user);

    User findByEmail(String email);
}