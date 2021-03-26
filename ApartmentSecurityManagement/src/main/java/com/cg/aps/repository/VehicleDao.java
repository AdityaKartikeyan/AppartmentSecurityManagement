package com.cg.aps.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entities.VehicleEntity;

/**
 * @author Anshul Joshi
 *
 */
@Repository
public interface VehicleDao extends JpaRepository<VehicleEntity, String> {
	List<VehicleEntity> findByName(String name);
	Optional<VehicleEntity> findByVehicleNo(String id);
}
