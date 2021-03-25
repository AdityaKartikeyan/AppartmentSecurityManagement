package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import com.cg.aps.entities.VehicleEntity;

/**
 * @author Anshul Joshi
 *
 */
public interface VehicleService {

	public VehicleEntity add(VehicleEntity bean);

	public VehicleEntity update(VehicleEntity bean);

	public void delete(VehicleEntity bean);

	public List<VehicleEntity> findByName(String name);

	public Optional<VehicleEntity> findByPk(String id);

	public List<VehicleEntity> search(VehicleEntity bean, long pageNo, int pageSize);

	public List<VehicleEntity> search();

}
