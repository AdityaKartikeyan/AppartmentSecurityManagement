package com.cg.aps.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entities.GuardTrainingEntity;
/**
 * @author Aditya
 *
 */
@Repository
public interface GuardTrainingDao extends JpaRepository<GuardTrainingEntity,Long>{

 Optional<GuardTrainingEntity> findByName(String name);
 Optional<GuardTrainingEntity> findByUserId(long id);
GuardTrainingEntity deleteById(long id);
}
