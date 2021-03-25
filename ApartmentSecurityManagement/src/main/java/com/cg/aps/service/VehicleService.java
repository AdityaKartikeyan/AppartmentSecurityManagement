package com.cg.aps.service;

import java.util.List;

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

	public VehicleEntity findByPk(long id);

	public List<VehicleEntity> search(VehicleEntity bean, long pageNo, int pageSize);

	public List<VehicleEntity> search(VehicleEntity bean);

}
