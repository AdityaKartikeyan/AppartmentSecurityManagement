package com.cg.aps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entities.GuardTrainingEntity;

@Repository
public interface GuardTrainingDao extends JpaRepository<GuardTrainingEntity,Integer>{

 List<GuardTrainingEntity> findByName(String name);
	
}
