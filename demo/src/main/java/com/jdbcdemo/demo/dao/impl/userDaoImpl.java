package com.jdbcdemo.demo.dao.impl;

import com.jdbcdemo.demo.dao.userDao;
import com.jdbcdemo.demo.entity.User;
import com.jdbcdemo.demo.factory.DataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class userDaoImpl implements userDao {

    @Autowired
    DataSourceFactory dataSourceFactory;

    @Override
    public Boolean addUser(User user) {

        Connection connection = dataSourceFactory.getConn();

        Boolean result = Boolean.FALSE;

        int employeeId = user.getEmployeeId();
        String name = user.getName();

        String sql = "insert into user (name, employeeId) values (?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, employeeId);
            preparedStatement.execute();
            connection.commit();
            result = Boolean.TRUE;
            System.out.println("add successfully!");
        } catch (SQLException e) {
            System.out.println("add failed, begin to roll back...");
            try {
                connection.rollback();
                return result;
            } catch (SQLException ex) {
                System.out.println("roll back failed...");
                return result;
            }
        }

        return result;


    }

    @Override
    public List<User> queryUsers(List<Integer> idList) {

        Connection connection = dataSourceFactory.getConn();

        List<User> users = new ArrayList<>();

        try {
            for (Integer id : idList){
                String sql = "select id, name, employeeId from user where id = ?";
                PreparedStatement pre = connection.prepareStatement(sql);
                ResultSet resultSet = pre.executeQuery();

                while ()
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void deleteUser(int id) {

    }
}
