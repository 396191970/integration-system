package com.tuobuxie.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tuobuxie.domain.ScoreUserCount;

public interface ScoreUserCountRepository extends JpaRepository<ScoreUserCount, Long>{


	Optional<ScoreUserCount> findByUserId(Long userId);

	@Transactional
	@Modifying
	@Query("update ScoreUserCount suc set suc.sum=:sum where suc.userId=:userId")
	void update(@Param("userId")Long userId , @Param("sum")Long sum);

	@Transactional
	@Modifying
	@Query("update ScoreUserCount suc set suc.sum=(suc.sum+ :sum) where suc.userId=:userId")
	void updateAdd(@Param("userId")Long userId , @Param("sum")Long sum);

	@Query("from ScoreUserCount suc join User u on suc.userId = u.id  where u.userName like %:userName%")
	Page<ScoreUserCount> findByUserName(@Param("userName")String userName ,Pageable pageable);

}
