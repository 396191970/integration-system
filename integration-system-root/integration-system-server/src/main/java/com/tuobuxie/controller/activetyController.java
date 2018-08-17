package com.tuobuxie.controller;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tuobuxie.domain.Activety;
import com.tuobuxie.repository.ActivetyRepository;
import com.tuobuxie.response.ResponseMessage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.apachecommons.CommonsLog;

/**
 * @author: lishaofeng
 **/
@RestController
@RequestMapping("/Activety")
@CommonsLog
@Api(value="增删查改活动",tags="活动接口")

public class activetyController {

	@Autowired
	ActivetyRepository activetyRepository;

	@ApiOperation("新增活动接口")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseMessage<Activety> save(@RequestBody  Activety Activety) {
		Activety =activetyRepository.save(Activety);
		ResponseMessage<Activety> ResponseMessage = new ResponseMessage<Activety>();
		ResponseMessage = ResponseMessage.success(Activety);
		return ResponseMessage;
	}
	@ApiOperation("删除活动接口")

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String del(@ApiParam(value = "活动id",required = true) @PathVariable Long id) {
		activetyRepository.deleteById(id);
		return "00";
	}
	@ApiOperation("修改活动接口")

	@RequestMapping( method = RequestMethod.PUT)
	public Activety update(@RequestBody  Activety Activety) {
		Activety =activetyRepository.save(Activety);
		return Activety;
	}
	@ApiOperation("根据id查找活动接口")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Activety>  get(@ApiParam(value = "活动id",required = true)@PathVariable Long id ) {

		return activetyRepository.findById(id);
	}
	@ApiOperation("查看所有活动接口")
	@RequestMapping(value = "/findall", method = RequestMethod.GET)
	public ResponseMessage<List<Activety>>  findAll( ) {
		List<Activety> list = activetyRepository.findAll();
		ResponseMessage<List<Activety>> ResponseMessage = new ResponseMessage<List<Activety>>();
		ResponseMessage = ResponseMessage.success(list);
		return ResponseMessage;
	}



}
