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
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void dummyItemTest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);

        // perform request and chcek if status is 200, check content
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().is(200))
                .andExpect(content().json("{\n" +
                        "    \"id\": 1,\n" +
                        "    \"price\": 100,\n" +
                        "    \"quantity\": 10,\n" +
                        "    \"name\": \"Ball\"\n" +
                        "}"))
                .andReturn();

        /*
        * .json() uses JSONAssert.assertEquals(expected, result.getResponse().getContentAsString()
        *
        * we get JSONAssert since we started a spring-boot project
        * */
    }

    @Test
    public void itemFromBusinessServiceTest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/item-from-business-service").accept(MediaType.APPLICATION_JSON);

        // perform request and chcek if status is 200, check content
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().is(200))
                .andExpect(content().json("{id: 1, name: Shyren, price: 10, quantity: 100}"))
                .andReturn();

        /*
        * .json() uses JSONAssert.assertEquals(expected, result.getResponse().getContentAsString()
        *
        * we get JSONAssert since we started a spring-boot project
        * */
    }


}

/*
* 1) Autowire MockMvc
* 2) Build the request
* 3) Verify by assertEquals
* */