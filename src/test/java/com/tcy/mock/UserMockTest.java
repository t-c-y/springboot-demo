package com.tcy.mock;

import com.tcy.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserMockTest {

    Logger log = LoggerFactory.getLogger(UserMockTest.class);

    @Mock
    private UserService userService;

    @Test
    public void userMockTest() {
        User u = new User();
        u.setId(1L);
        u.setName("张三");
        u.setAge(20);
        when(userService.findUserById(eq(1L))).thenReturn(u);
        User u1 = userService.findUserById(1L);
        log.info(String.valueOf(u));
        log.info(String.valueOf(u1));
        log.info(String.valueOf(u == u1));
    }

}
