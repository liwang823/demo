package com.jdbcdemo.demo.controller;

import com.jdbcdemo.demo.entity.AddResponse;
import com.jdbcdemo.demo.entity.QueryRequest;
import com.jdbcdemo.demo.entity.QueryResponse;
import com.jdbcdemo.demo.entity.User;
import com.jdbcdemo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        @RequestMapping("/queryUser")
    public QueryResponse queryUser(@RequestBody QueryRequest request){

        QueryResponse queryResponse = new QueryResponse();

        String idListParam = request.getIdList();
        if (idListParam == null){
            queryResponse.setCode(200);
            queryResponse.setMsg("入参错误!");
            return queryResponse;
        }

        String[] idList = idListParam.split(",");
        List<Integer> ids = Arrays.stream(idList).map(Integer::parseInt).collect(Collectors.toList());
        List<User> users = userService.queryUsers(ids);

        queryResponse.setCode(200);
        queryResponse.setMsg("success");
        queryResponse.setData(users);

        return queryResponse;
    }
}
