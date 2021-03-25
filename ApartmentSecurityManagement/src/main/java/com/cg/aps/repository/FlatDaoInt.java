package com.cg.aps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entities.FlatEntity;
import com.cg.aps.entities.FlatRentEntity;

	@Repository
	public interface FlatDaoInt extends JpaRepository<FlatEntity, Integer> {
		List<FlatEntity> findByOwnerName(String name);
	}
	
	

