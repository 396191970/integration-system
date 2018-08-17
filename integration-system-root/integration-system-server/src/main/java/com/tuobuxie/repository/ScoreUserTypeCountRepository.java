package com.tuobuxie.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tuobuxie.domain.ScoreUserTypeCount;

public interface ScoreUserTypeCountRepository extends JpaRepository<ScoreUserTypeCount, Long>{

	Optional<ScoreUserTypeCount> findByUserId(Long userId);
	Optional<ScoreUserTypeCount> findByUserIdAndTypeId(Long userId ,Long typeId);

	Page<ScoreUserTypeCount> findAllByTypeId(Long typeId,Pageable pageable);


	@Transactional
	@Modifying
	@Query("update ScoreUserTypeCount suc set suc.count=:count where suc.userId=:userId  and suc.typeId=:typeId  ")
	void update(@Param("userId")Long userId ,@Param("typeId")Long typeId ,@Param("count") Long count);

	@Transactional
	@Modifying
	@Query("update ScoreUserTypeCount suc set suc.count=(suc.count+ :count) where suc.userId=:userId and suc.typeId=:typeId ")
	void updateAdd(@Param("userId")Long userId ,@Param("typeId")Long typeId, @Param("count")Long count);


	@Query("from ScoreUserTypeCount suc join User u on suc.userId = u.id  where suc.typeId=:typeId  and u.userName like %:userName%")
	Page<ScoreUserTypeCount> findByUserId(@Param("userName")String userName ,@Param("typeId")Long typeId ,Pageable pageable);
}
