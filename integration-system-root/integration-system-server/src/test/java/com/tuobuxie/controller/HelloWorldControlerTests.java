package com.tuobuxie.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.alibaba.fastjson.JSON;
import com.tuobuxie.domain.Type;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class HelloWorldControlerTests {

	private MockMvc mvc;
	@Autowired
	private TypeController restController;
	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(restController).build();
	}

	@Test
	public void getHello() throws Exception {
		Type type = new Type();
		type.setDescription("1234");
		type.setScore(12L);
		type.setTypeName("test");

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
				.post("/type/add")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(JSON.toJSONString(type));

		mvc.perform(builder).andReturn().getResponse().getContentAsString();


	}

}