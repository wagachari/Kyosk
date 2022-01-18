package com.KyoskTest.Kyosk.controllers;

import com.KyoskTest.Kyosk.controller.ConfigurationController;
import com.KyoskTest.Kyosk.service.ConfigurationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConfigurationController.class)
public class ConfigurationControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    ConfigurationService configurationService;

    @Test
    void create() throws Exception {

        ConfigurationController configClass = new ConfigurationController();

        RequestBuilder request = MockMvcRequestBuilders.get("/configs");

        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("{\n" +
                "    \"name\":\"datacenter-2\",\n" +
                "    \"metadata\":{\n" +
                "        \"monitoring\":{\n" +
                "            \"enabled\":\"false\"\n" +
                "        },\n" +
                "    \"limits\":{\n" +
                "        \"cpu\":{\n" +
                "            \"enabled\":\"true\",\n" +
                "            \"value\":\"300m\"\n" +
                "        }\n" +
                "    }\n" +
                "    }\n" +
                "}\n", result.getResponse().getContentAsString());
    }
//TODO: tests for insertion

    //test for validation
}
