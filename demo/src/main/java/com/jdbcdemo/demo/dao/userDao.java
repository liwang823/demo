package com.jdbcdemo.demo.dao;

import com.jdbcdemo.demo.entity.User;

import java.util.List;

public interface userDao {

    Boolean addUser(User user);

    List<User> queryUsers(List<Integer> idList);

    void deleteUser(int id);

}
