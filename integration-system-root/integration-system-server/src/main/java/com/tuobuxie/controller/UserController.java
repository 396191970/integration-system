package com.tuobuxie.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tuobuxie.domain.User;
import com.tuobuxie.repository.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.apachecommons.CommonsLog;

/**
 * @author: lishaofeng
 **/
@RestController
@RequestMapping("/User")
@CommonsLog
@Api(value="增删查改用户",tags="用户接口")

public class UserController {

	@Autowired
	UserRepository userRepository;

	@ApiOperation("新增用户接口")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public User save(@RequestBody  User User) {
		User =userRepository.save(User);

        return User;
    }
	@ApiOperation("删除用户接口")

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String del(@ApiParam(value = "用户id",required = true) @PathVariable Long id) {
    	userRepository.deleteById(id);
        return "00";
    }
	@ApiOperation("修改用户接口")

    @RequestMapping( method = RequestMethod.PUT)
    public User update(@RequestBody  User User) {
		User =userRepository.save(User);
        return User;
    }
	@ApiOperation("根据id查找用户接口")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<User>  get(@ApiParam(value = "用户id",required = true)@PathVariable Long id ) {

        return userRepository.findById(id);
    }
	@ApiOperation("查改所有用户接口")

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public List<User>  findAll( ) {

        return userRepository.findAll();
    }
}
