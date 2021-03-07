package com.tcy.service;

import com.tcy.Application;
import com.tcy.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
@Rollback
public class UserServiceTest {

    Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    private UserService userService;

    @Test
    public void listUserTest() {
        logger.info(String.valueOf(userService.listUser()));
    }

    @Test
    public void saveUserTest() {
        User user = new User();
        user.setAge(22);
        user.setName("李四");
        int result = userService.saveUser(user);
        logger.info(String.valueOf(result));
    }

}
