package com.cg.aps.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entities.FlatEntity;
import com.cg.aps.entities.FlatRentEntity;

	@Repository
	public interface FlatDaoInt extends JpaRepository<FlatEntity, Long> {
		Optional<FlatEntity> findByOwnerName(String name);
		Optional<FlatEntity> findByFlatNo(String flatNo);
		FlatEntity deleteById(long id);

		
	}
	
	

