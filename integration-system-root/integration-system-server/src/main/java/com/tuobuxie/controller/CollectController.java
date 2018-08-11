package com.tuobuxie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tuobuxie.domain.Collect;
import com.tuobuxie.repository.CollectRepository;

/**
 * @author: lishaofeng
 **/
@RestController
@RequestMapping("/collect")
public class CollectController {

	@Autowired
	CollectRepository collectRepository;

    @GetMapping("/add")
    public String add(@RequestParam String name) {
    	Collect collect =new Collect();
    	collect.setCategory("category");
    	collect.setCollectTime("2012");
    	collect.setRemark(name);
    	collect.setCreateTime(System.currentTimeMillis());
    	collect.setLastModifyTime(System.currentTimeMillis());
    	collect.setCharset("utf-8");
    	collect.setDescription("description");
    	collect.setFavoritesId(1L);
    	collect.setLogoUrl("logurl");
    	collect.setNewFavorites("new favorites");
    	collect.setTitle("title");
    	collect.setUrl("url");
    	collect.setUserId(234L);
    	collectRepository.save(collect);
        return "collect: " + collect.toString();
    }

}
