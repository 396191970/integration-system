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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tuobuxie.domain.ScoreUserCount;
import com.tuobuxie.repository.ScoreChangeListRepository;
import com.tuobuxie.repository.ScoreUserCountRepository;
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
@RequestMapping("/ScoreUserCount")
@CommonsLog
@Api(value="增删查改用户总积分",tags="用户总积分接口")

public class ScoreUserCountController {

	@Autowired
	ScoreUserCountRepository scoreUserCountRepository;

	@Autowired
	ScoreChangeListRepository ScoreChangeListRepository;

	@ApiOperation("根据用户id查找总积分接口")
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public Optional<ScoreUserCount>  get(@ApiParam(value = "用户总积分",required = true)@PathVariable Long userId ) {

		return scoreUserCountRepository.findByUserId(userId);
	}


	@ApiOperation("查看所有用户总积分接口")
	@ApiImplicitParams(value = {@ApiImplicitParam(name="sortDirection",value="DESC ：降序 ； ASC  ：升序"),
			@ApiImplicitParam(name="userName",value="用户姓名"),
			@ApiImplicitParam(name="pageIndex",value="第几页"),
			@ApiImplicitParam(name="size",value="每页条数"),

	})
	@RequestMapping(value = "/seach", method = RequestMethod.POST)
	public ResponseMessage<Page<ScoreUserCount>>  seach(String userName ,String sortDirection,Integer pageIndex,Integer size){
		ResponseMessage<Page<ScoreUserCount>> ResponseMessage = new ResponseMessage<Page<ScoreUserCount>>();
		Page<ScoreUserCount> page =null;
		Sort sort =  null;

		if(pageIndex == null ||size ==0)
			size = 100;
		if(pageIndex == null)
			pageIndex = 0;

		String sortName="sum";

		if(StringUtils.isNotEmpty(sortDirection) )
		{
			if("DESC".equalsIgnoreCase(sortDirection))
				sort = new Sort(Direction.DESC, sortName);
			else if("ASC".equalsIgnoreCase(sortDirection))
				sort = new Sort(Direction.ASC, sortName);
		}
		else
		{
			sort = new Sort(Direction.DESC, sortName);

		}

		Pageable pageable =  PageRequest.of(pageIndex, size, sort);

		if(StringUtils.isEmpty(userName))
			page =scoreUserCountRepository.findAll(pageable);
		else
			page =scoreUserCountRepository.findByUserName(userName,pageable);


		ResponseMessage = ResponseMessage.success(page);
		return ResponseMessage;

	}

	@ApiOperation("重新统计用户总积分")

	@RequestMapping(value = "/updateScoreUserCount", method = RequestMethod.GET)
	public ResponseMessage<List<ScoreUserCount>>  updateScoreUserCount(){
		ResponseMessage<List<ScoreUserCount>> ResponseMessage = new ResponseMessage<List<ScoreUserCount>>();

		List<ScoreUserCount> list =ScoreChangeListRepository.findScoreUserCount();
		if(list.size()>0)
			scoreUserCountRepository.deleteAll();

		for (ScoreUserCount scoreUserCount : list) {
			scoreUserCountRepository.save(scoreUserCount);
		}

		ResponseMessage = ResponseMessage.success(list);
		return ResponseMessage;

	}


}
