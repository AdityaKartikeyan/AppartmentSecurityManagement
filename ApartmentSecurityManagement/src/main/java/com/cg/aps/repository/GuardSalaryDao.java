package com.cg.aps.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.aps.entities.GuardSalaryEntity;

/**
 * @author Aravind
 *
 */
public interface GuardSalaryDao extends JpaRepository<GuardSalaryEntity, Long> {
	Optional<GuardSalaryEntity> findByName(String name);

	Optional<GuardSalaryEntity> findByUserId(long id);

	GuardSalaryEntity deleteById(long id);
}
