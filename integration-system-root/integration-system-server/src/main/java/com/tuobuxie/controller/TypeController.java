package com.tuobuxie.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tuobuxie.domain.Type;
import com.tuobuxie.repository.TypeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.apachecommons.CommonsLog;

/**
 * @author: lishaofeng
 **/
@RestController
@RequestMapping("/type")
@CommonsLog
@Api(value="增删查改类型",tags="类型接口")

public class TypeController {

	@Autowired
	TypeRepository typeRepository;

	@ApiOperation("新增类型接口")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Type save(@RequestBody  Type type) {
		type =typeRepository.save(type);

        return type;
    }
	@ApiOperation("删除类型接口")

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String del(@ApiParam(value = "类型id",required = true) @PathVariable Long id) {
    	typeRepository.deleteById(id);
        return "00";
    }
	@ApiOperation("修改类型接口")

    @RequestMapping( method = RequestMethod.PUT)
    public Type update(@RequestBody  Type type) {
		type =typeRepository.save(type);
        return type;
    }
	@ApiOperation("根据id查找类型接口")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Type>  get(@ApiParam(value = "类型id",required = true)@PathVariable Long id ) {

        return typeRepository.findById(id);
    }
	@ApiOperation("查改所有类型接口")

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public List<Type>  findAll( ) {

        return typeRepository.findAll();
    }
}
