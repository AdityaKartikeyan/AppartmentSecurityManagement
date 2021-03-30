package com.cg.aps.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entities.FlatRentEntity;

	@Repository
	public interface FlatRentDaoInt extends JpaRepository<FlatRentEntity, Long> {
		Optional<FlatRentEntity> findByOwnerName(String name);
		Optional<FlatRentEntity> findByFlatNo(String flatNo);
		FlatRentEntity deleteById(long id);
		
		
	}
	
	

