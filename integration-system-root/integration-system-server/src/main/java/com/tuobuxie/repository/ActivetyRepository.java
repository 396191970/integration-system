package com.tuobuxie.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tuobuxie.domain.Activety;

public interface ActivetyRepository extends JpaRepository<Activety, Long>{
	 public Page<Activety> findByActivetyNameLike(String activetyName ,Pageable page);


}
