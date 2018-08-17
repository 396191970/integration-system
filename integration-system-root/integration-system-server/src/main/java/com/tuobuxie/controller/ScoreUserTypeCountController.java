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

import com.tuobuxie.domain.ScoreUserTypeCount;
import com.tuobuxie.repository.ScoreChangeListRepository;
import com.tuobuxie.repository.ScoreUserTypeCountRepository;
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
@RequestMapping("/ScoreUserTypeCount")
@CommonsLog
@Api(value="增删查改用户类型总次数",tags="用户类型总次数接口")

public class ScoreUserTypeCountController {

	@Autowired
	ScoreUserTypeCountRepository ScoreUserTypeCountRepository;

	@Autowired
	ScoreChangeListRepository ScoreChangeListRepository;

	@ApiOperation("根据用户查找接口")
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public Optional<ScoreUserTypeCount>  get(@ApiParam(value = "用户id",required = true)@PathVariable Long userId ) {

		return ScoreUserTypeCountRepository.findByUserId(userId);
	}

	@ApiOperation("根据用户和类型查找接口")
	@ApiImplicitParams(value = {@ApiImplicitParam(name="userId",value="用户id"),
			@ApiImplicitParam(name="typeId",value="类型id"),
	})
	@RequestMapping(value = "/findByUserIdAndTypeId", method = RequestMethod.GET)
	public Optional<ScoreUserTypeCount>  findByUserIdAndTypeId( Long userId ,Long typeId ) {

		return ScoreUserTypeCountRepository.findByUserIdAndTypeId(userId,typeId);
	}


	@ApiOperation("查看所有用户类型总次数接口")
	@ApiImplicitParams(value = {@ApiImplicitParam(name="sortDirection",value="DESC ：降序 ； ASC  ：升序"),
			@ApiImplicitParam(name="userName",value="用户姓名"),
			@ApiImplicitParam(name="typeId",value="类型"),
			@ApiImplicitParam(name="pageIndex",value="第几页"),
			@ApiImplicitParam(name="size",value="每页条数"),

	})
	@RequestMapping(value = "/seach", method = RequestMethod.POST)
	public ResponseMessage<Page<ScoreUserTypeCount>>  seach(String userName ,Long typeId, String sortDirection,Integer pageIndex,Integer size){
		ResponseMessage<Page<ScoreUserTypeCount>> ResponseMessage = new ResponseMessage<Page<ScoreUserTypeCount>>();
		Page<ScoreUserTypeCount> page =null;
		Sort sort =  null;

		if(pageIndex == null ||size ==0)
			size = 100;
		if(pageIndex == null)
			pageIndex = 0;

		String sortName="count";

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

		if(null ==typeId)
			page =ScoreUserTypeCountRepository.findAll(pageable);
		else if(StringUtils.isEmpty(userName))
			page =ScoreUserTypeCountRepository.findAllByTypeId(typeId,pageable);
		else
			page =ScoreUserTypeCountRepository.findByUserId(userName, typeId, pageable);




		ResponseMessage = ResponseMessage.success(page);
		return ResponseMessage;

	}

	@ApiOperation("重新统计用户类型总次数")

	@RequestMapping(value = "/updateScoreUserTypeCount", method = RequestMethod.GET)
	public ResponseMessage<List<ScoreUserTypeCount>>  updateScoreUserTypeCount(){
		ResponseMessage<List<ScoreUserTypeCount>> ResponseMessage = new ResponseMessage<List<ScoreUserTypeCount>>();

		List<ScoreUserTypeCount> list =ScoreChangeListRepository.findScoreUserTypeCount();
		if(list.size()>0)
			ScoreUserTypeCountRepository.deleteAll();

		for (ScoreUserTypeCount ScoreUserTypeCount : list) {
			ScoreUserTypeCountRepository.save(ScoreUserTypeCount);
		}

		ResponseMessage = ResponseMessage.success(list);
		return ResponseMessage;

	}


}
