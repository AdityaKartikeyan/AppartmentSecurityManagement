package com.cg.aps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.aps.entities.GuardSalaryEntity;

/**
 * @author Aravind
 *
 */
public interface GuardSalaryDao extends JpaRepository<GuardSalaryEntity, Integer> {
	 List<GuardSalaryEntity> findByName(String name);

}
