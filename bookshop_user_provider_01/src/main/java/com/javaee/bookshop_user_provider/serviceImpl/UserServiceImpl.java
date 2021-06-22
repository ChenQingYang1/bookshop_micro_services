package com.javaee.bookshop_user_provider.serviceImpl;

import com.javaee.bookshop_user_provider.dao.IUserDao;
import com.javaee.bookshop_user_provider.entity.User;
import com.javaee.bookshop_user_provider.serviceInterface.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private IUserDao userDao;

    @Override
    public void add(User user) {
        userDao.addUser(user);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}