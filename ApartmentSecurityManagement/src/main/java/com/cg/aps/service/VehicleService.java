package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import com.cg.aps.entities.VehicleEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;

/**
 * @author Anshul Joshi
 *
 */
public interface VehicleService {

	public VehicleEntity add(VehicleEntity bean) throws DuplicateRecordException;

	public VehicleEntity update(VehicleEntity bean) throws RecordNotFoundException;

	public VehicleEntity delete(long id) throws RecordNotFoundException;

	public VehicleEntity findByName(String name) throws RecordNotFoundException;

	public VehicleEntity findByPk(String id) throws RecordNotFoundException;

	public List<VehicleEntity> search(VehicleEntity bean, long pageNo, int pageSize);

	public List<VehicleEntity> search() throws DatabaseException;

}
