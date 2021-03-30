package com.filtertest.demo.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.jayway.jsonpath.JsonPath;

@AutoConfigureMockMvc
@SpringBootTest
class HomeControllerTest {

    @Autowired
    private HomeController homeController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("测试controller返回")
    void home1() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/home/home?v=3")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertThat(content, equalTo("this is home,v=3"));
    }

    @Test
    @DisplayName("测试过滤器返回")
    void home2() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/home/home")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertThat(content, equalTo("缺少参数"));
    }
}