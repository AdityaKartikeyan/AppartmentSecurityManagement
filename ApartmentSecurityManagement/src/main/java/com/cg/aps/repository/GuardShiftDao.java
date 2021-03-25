package com.cg.aps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entities.GuardShiftEntity;

/**
 * @author HP
 *
 */
@Repository
public interface GuardShiftDao extends JpaRepository<GuardShiftEntity,Integer>
{
	List<GuardShiftEntity> findByName(String name);
}
	