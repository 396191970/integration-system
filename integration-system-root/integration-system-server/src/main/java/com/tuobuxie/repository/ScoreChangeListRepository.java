package com.tuobuxie.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tuobuxie.domain.ScoreChangeList;
import com.tuobuxie.domain.ScoreUserCount;
import com.tuobuxie.domain.ScoreUserTypeCount;

public interface ScoreChangeListRepository extends JpaRepository<ScoreChangeList, Long>{


	 @Query(" select new ScoreChangeList(s,u.userName,t.typeName,a.activetyName)  from ScoreChangeList s join  User u on s.userId=u.id"
	 		+ " join  Activety a on s.activityId=a.id"
	 		+ " join  Type t on s.typeId=t.typeId")
	 public Page<ScoreChangeList> findAll(Pageable page);

	 @Query(" select new ScoreUserCount(u.userName ,s.userId , sum(s.score)) from ScoreChangeList s join User u on s.userId = u.id  group by s.userId")
	 public List<ScoreUserCount> findScoreUserCount();


	 @Query(" select new ScoreUserTypeCount(u.userName ,s.userId ,t.typeId ,t.typeName, count(s.score)) from ScoreChangeList s join User u on s.userId = u.id join Type t on s.typeId = t.typeId  group by s.userId ,s.typeId")
	 public List<ScoreUserTypeCount> findScoreUserTypeCount();




}
