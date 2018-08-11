package com.tuobuxie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tuobuxie.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{



}
