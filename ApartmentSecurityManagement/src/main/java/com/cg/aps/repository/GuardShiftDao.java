package com.cg.aps.repository;

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

}
