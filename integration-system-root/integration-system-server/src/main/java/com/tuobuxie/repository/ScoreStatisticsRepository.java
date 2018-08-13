package com.tuobuxie.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tuobuxie.domain.ScoreStatistics;

public interface ScoreStatisticsRepository extends JpaRepository<ScoreStatistics, Long>{


}
