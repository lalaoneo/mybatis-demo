package com.lori.mybatisdemo.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lori.mybatisdemo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testPersonService() {

        /**
         * cityId 决定哪个库
         * cityId%2 = 0 在shardingJdbc0库
         * cityId%2 = 1 在shardingJdbc1库
         *
         * userId 决定哪个表
         * userId%2 = 0 在user0表
         * userId%2 = 1 在user1表
         */
        List<User> users = new ArrayList<>();
        // cityId = 2 在shardingJdbc0库, userId = 2  在user0表
        User user0 = createUser(2,2,"lori_00");
        users.add(user0);
        // cityId = 2 在shardingJdbc0库, userId = 1  在user1表
        User user1 = createUser(2,1,"lori_01");
        users.add(user1);
        // cityId = 2 在shardingJdbc1库, userId = 2  在user0表
        User user2 = createUser(1,2,"lori_10");
        users.add(user2);
        // cityId = 2 在shardingJdbc1库, userId = 1  在user1表
        User user3 = createUser(1,1,"lori_11");
        users.add(user3);
        users.forEach(user -> userService.saveUser(user));

    }

    private User createUser(Integer cityId,Integer userId,String userName) {
        User user = new User();
        user.setUserId(userId);
        user.setCityId(cityId);
        user.setUserName(userName);
        user.setAge(30);
        user.setSex(1);
        user.setCreateTime(new Date());
        user.setCreateUser("lori");
        user.setUpdateTime(new Date());
        user.setUpdateUser("lori");
        user.setYn(1);
        return user;
    }
}
