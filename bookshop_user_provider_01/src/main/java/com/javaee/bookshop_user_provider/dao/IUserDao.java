package com.javaee.bookshop_user_provider.dao;

import com.javaee.bookshop_user_provider.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("userDao")
public interface IUserDao {
    User findByEmail(String email);

    void addUser(User user);
}
