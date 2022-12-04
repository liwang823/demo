package com.jdbcdemo.demo.service;

import com.jdbcdemo.demo.dao.impl.userDaoImpl;
import com.jdbcdemo.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    userDaoImpl userDao;

    public Boolean addUser(User user){

        if (user == null || user.getEmployeeId() == null || user.getName() == null) return false;

        String name = user.getName();
        int id = user.getEmployeeId();

        User newUser = new User();
        newUser.setEmployeeId(id);
        newUser.setName(name);

        return userDao.addUser(newUser);
    }

    public List<User> queryUsers(List<Integer> employeeIdList){

        List<User> users = new ArrayList<>();

        if (employeeIdList == null || employeeIdList.size() == 0) return users;

        users = userDao.queryUsers(employeeIdList);

        return users;
    }
}
