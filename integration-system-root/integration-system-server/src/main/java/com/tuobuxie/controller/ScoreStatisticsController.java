package com.tuobuxie.controller;

import java.util.List;
import java.util.Optional;

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

import com.tuobuxie.domain.ScoreStatistics;
import com.tuobuxie.domain.enums.CountOrdertType;
import com.tuobuxie.repository.ScoreStatisticsRepository;

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
@RequestMapping("/ScoreStatistics")
@CommonsLog
@Api(value="增删查看积分统计",tags="积分统计接口")

public class ScoreStatisticsController {

	@Autowired
	ScoreStatisticsRepository ScoreStatisticsRepository;

	@ApiOperation("新增积分统计接口")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ScoreStatistics save(@RequestBody  ScoreStatistics ScoreStatistics) {
		ScoreStatistics =ScoreStatisticsRepository.save(ScoreStatistics);

		return ScoreStatistics;
	}
	@ApiOperation("删除积分统计接口")

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String del(@ApiParam(value = "积分统计id",required = true) @PathVariable Long id) {
		ScoreStatisticsRepository.deleteById(id);
		return "00";
	}
	@ApiOperation("修改积分统计接口")

	@RequestMapping( method = RequestMethod.PUT)
	public ScoreStatistics update(@RequestBody  ScoreStatistics ScoreStatistics) {
		ScoreStatistics =ScoreStatisticsRepository.save(ScoreStatistics);
		return ScoreStatistics;
	}
	@ApiOperation("根据id查找积分统计接口")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<ScoreStatistics>  get(@ApiParam(value = "积分统计id",required = true)@PathVariable Long id ) {

		return ScoreStatisticsRepository.findById(id);
	}
	@ApiOperation("查看所有积分统计接口")
	@RequestMapping(value = "/findall", method = RequestMethod.GET)
	public List<ScoreStatistics>  findAll( ) {

		return ScoreStatisticsRepository.findAll();
	}

	@ApiOperation("查看积分排序接口")
	@ApiImplicitParams(value = { @ApiImplicitParam(name="sortName",value="排序名称 ：	scoreCount,joinCount,cancelCount,launchCount,plainCount,showCount,writeCount,moveThingsCount,buyCount,pictureCount,"),
			@ApiImplicitParam(name="sortDirection",value="DESC ：降序 ； ASC  ：升序"),

	})
	@RequestMapping(value = "/findallOrder", method = RequestMethod.GET)
	public Page<ScoreStatistics>  findAllOrder(String sortName ,String sortDirection){
		int page=0,size=100;
		Sort sort = null;
		if("DESC".equalsIgnoreCase(sortDirection))
			sort = new Sort(Direction.DESC, sortName);
		else if("ASC".equalsIgnoreCase(sortDirection))
			sort = new Sort(Direction.ASC, sortName);

		Pageable pageable =  PageRequest.of(page, size, sort);
		return ScoreStatisticsRepository.findAll(pageable);

	}


}
