package com.cg.aps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entities.GuardTrainingEntity;

@Repository
public interface GuardTrainingDao extends JpaRepository<GuardTrainingEntity,Integer>{

	
}
