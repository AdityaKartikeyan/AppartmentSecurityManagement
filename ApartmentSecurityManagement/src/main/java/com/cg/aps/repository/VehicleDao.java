package com.cg.aps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entities.VehicleEntity;

@Repository
public interface VehicleDao extends JpaRepository<VehicleEntity, Integer> {

}
