package com.jdbcdemo.demo.controller;

import com.jdbcdemo.demo.entity.AddResponse;
import com.jdbcdemo.demo.entity.User;
import com.jdbcdemo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    UserService userService;

    @RequestMapping("/addUser")
    public AddResponse addUser(@RequestBody User user){
        Boolean result = userService.addUser(user);
        AddResponse res = new AddResponse();

        if (result){
            res.setCode(200);
            res.setMsg("success");
        }else {
            res.setCode(200);
            res.setMsg("fail");
        }

        return res;
    }
}
