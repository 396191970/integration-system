package com.tuobuxie.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tuobuxie.domain.ScoreChangeList;
import com.tuobuxie.repository.ScoreChangeListRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.apachecommons.CommonsLog;

/**
 * @author: lishaofeng
 **/
@RestController
@RequestMapping("/ScoreChangeList")
@CommonsLog
@Api(value="增删查看积分变更记录",tags="积分变更记录接口")

public class ScoreChangeListController {

	@Autowired
	ScoreChangeListRepository ScoreChangeListRepository;

	@ApiOperation("新增积分变更记录接口")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ScoreChangeList save(@RequestBody  ScoreChangeList ScoreChangeList) {
		ScoreChangeList =ScoreChangeListRepository.save(ScoreChangeList);

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
	@ApiOperation("查看所有积分变更记录接口")

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public List<ScoreChangeList>  findAll( ) {

        return ScoreChangeListRepository.findAll();
    }
}
