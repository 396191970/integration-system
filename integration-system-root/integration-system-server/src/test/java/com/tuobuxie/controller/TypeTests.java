package com.tuobuxie.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSON;
import com.tuobuxie.domain.Type;


public class TypeTests {

public static void main(String[] args) {
	Type type = new Type();
	type.setTypeId(1L);
	type.setDescription("1234");
	type.setScore(12);
	type.setTypeName("test");
	System.out.println(JSON.toJSONString(type));
}
}