package com.shyren.unittesting.unittesting.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void helloWorldBasicTest() throws Exception {
        // call "/hello-world" and verify it's response i.e GET app/json
        // we do this by using mockMvc

        // building request
        RequestBuilder request = MockMvcRequestBuilders.get("/hello-world").accept(MediaType.APPLICATION_JSON);

        // perform request and chcek if status is 200, check content
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().is(200))
                .andExpect(content().string("Hello World"))
                .andReturn();

        // if the response is json, we can write
        // .andExpect(content().json(JSON))

        // now verify the content of result if it contains HEllo world
        assertEquals("Hello World", mvcResult.getResponse().getContentAsString());
    }
}

/*
* 1) Autowire MockMvc
* 2) Build the request
* 3) Verify by assertEquals
* */