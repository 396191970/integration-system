package com.tuobuxie.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tuobuxie.domain.ScoreChangeList;
import com.tuobuxie.repository.ScoreChangeListRepository;
import com.tuobuxie.response.ResponseMessage;
import com.tuobuxie.services.ScoreChangeListService;

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
@RequestMapping("/ScoreChangeList")
@CommonsLog
@Api(value="增删查改积分变更记录",tags="积分变更记录接口")

public class ScoreChangeListController {

	@Autowired
	ScoreChangeListRepository ScoreChangeListRepository;

	@Autowired
	ScoreChangeListService scoreChangeListService;

	@ApiOperation("新增积分变更记录接口")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ScoreChangeList save(@RequestBody  ScoreChangeList ScoreChangeList) {

		ScoreChangeList =scoreChangeListService.add(ScoreChangeList);

        return ScoreChangeList;
    }
	@ApiOperation("删除积分变更记录接口")

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String del(@ApiParam(value = "积分变更记录id",required = true) @PathVariable Long id) {
    	ScoreChangeListRepository.deleteById(id);
        return "00";
    }
	@ApiOperation("修改积分变更记录接口")

    @RequestMapping( method = RequestMethod.PUT)
    public ScoreChangeList update(@RequestBody  ScoreChangeList ScoreChangeList) {
		ScoreChangeList =ScoreChangeListRepository.save(ScoreChangeList);
        return ScoreChangeList;
    }
	@ApiOperation("根据id查找积分变更记录接口")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<ScoreChangeList>  get(@ApiParam(value = "积分变更记录id",required = true)@PathVariable Long id ) {

        return ScoreChangeListRepository.findById(id);
    }
	@ApiOperation("查改所有积分变更记录接口")

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public List<ScoreChangeList>  findAll( ) {

        return ScoreChangeListRepository.findAll();
    }

	@ApiOperation("查询积分变更记录")
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name="userName",value="用户姓名"),
			@ApiImplicitParam(name="pageIndex",value="第几页"),
			@ApiImplicitParam(name="size",value="每页条数"),

	})

	@RequestMapping(value = "/seach", method = RequestMethod.GET)
	public ResponseMessage<Page<ScoreChangeList>>  seach(String userName ,Integer pageIndex,Integer size){
		ResponseMessage<Page<ScoreChangeList>> ResponseMessage = new ResponseMessage<Page<ScoreChangeList>>();
		Page<ScoreChangeList> page =null;

		if(pageIndex == null ||size ==0)
			size = 100;
		if(pageIndex == null)
			pageIndex = 0;


		Pageable pageable =  PageRequest.of(pageIndex, size);


		page =ScoreChangeListRepository.findAll(pageable);


		ResponseMessage = ResponseMessage.success(page);
		return ResponseMessage;

	}


}
