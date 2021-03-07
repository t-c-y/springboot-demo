package com.tcy.controller;

import com.tcy.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
//@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = Application.class)
public class UserControllerTest {

    Logger logger = LoggerFactory.getLogger(UserControllerTest.class);

    @Autowired
    private MockMvc mvc;

    @Test
    public void listUserTest() {
        try {
            ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/user/"));
            MvcResult mvcResult = resultActions.andReturn();
            logger.info(
                    String.valueOf(
                            mvcResult.getResponse().getStatus() + ":"
                                    + mvcResult.getResponse().getContentAsString()
                            )
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
