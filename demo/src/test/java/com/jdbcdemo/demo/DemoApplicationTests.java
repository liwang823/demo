package com.jdbcdemo.demo;

import com.jdbcdemo.demo.factory.DataSourceFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    DataSourceFactory dataSourceFactory;

    @Test
    void contextLoads() {
        System.out.println(dataSourceFactory.getClass());
    }

}
