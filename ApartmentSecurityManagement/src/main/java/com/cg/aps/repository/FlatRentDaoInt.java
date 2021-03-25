package com.cg.aps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entities.FlatRentEntity;

import java.util.List;

	@Repository
	public interface FlatRentDaoInt extends JpaRepository<FlatRentEntity, Integer> {
		List<FlatRentEntity> findByOwnerName(String name);
	}
	
	

