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

import lombok.extern.apachecommons.CommonsLog;

/**
 * @author: lishaofeng
 **/
@RestController
@RequestMapping("/type")
@CommonsLog
public class TypeController {

	@Autowired
	TypeRepository typeRepository;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Type save(@RequestBody  Type type) {
    	typeRepository.save(type);

        return type;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String del(@PathVariable Long id) {
    	typeRepository.deleteById(id);
        return "00";
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Type update(@PathVariable Long id ,@RequestBody  Type type) {
    	type.setTypeId(id);
    	typeRepository.save(type);
        return type;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Type>  get(@PathVariable Long id ) {

        return typeRepository.findById(id);
    }
    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public List<Type>  findAll( ) {

        return typeRepository.findAll();
    }
}
