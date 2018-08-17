package com.tuobuxie.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuobuxie.domain.ScoreChangeList;
import com.tuobuxie.repository.ScoreChangeListRepository;
import com.tuobuxie.repository.ScoreUserCountRepository;
import com.tuobuxie.repository.ScoreUserTypeCountRepository;

@Service
public  class ScoreChangeListService {

	@Autowired
	ScoreUserCountRepository scoreUserCountRepository;

	@Autowired
	ScoreUserTypeCountRepository scoreUserTypeCountRepository;

	@Autowired
	ScoreChangeListRepository scoreChangeListRepository;

	@Transactional
	public ScoreChangeList add(ScoreChangeList scoreChangeList) {

		scoreChangeList = scoreChangeListRepository.save(scoreChangeList);

		scoreUserCountRepository.updateAdd(scoreChangeList.getUserId(), scoreChangeList.getScore());
		scoreUserTypeCountRepository.updateAdd(scoreChangeList.getUserId(), scoreChangeList.getTypeId(), scoreChangeList.getScore());

		return scoreChangeList;

	}

	@Transactional
	public ScoreChangeList delete(ScoreChangeList scoreChangeList) {

		scoreChangeListRepository.delete(scoreChangeList);

		scoreUserCountRepository.updateAdd(scoreChangeList.getUserId(), -scoreChangeList.getScore());
		scoreUserTypeCountRepository.updateAdd(scoreChangeList.getUserId(), scoreChangeList.getTypeId(), -scoreChangeList.getScore());

		return scoreChangeList;

	}
}
