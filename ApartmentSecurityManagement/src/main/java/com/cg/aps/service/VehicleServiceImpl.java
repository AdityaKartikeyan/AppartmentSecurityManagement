package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cg.aps.entities.VehicleEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.repository.VehicleDao;

/**
 * @author Anshul Joshi
 *
 */
@Service("VehicleService")
@Transactional
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleDao dao;

	@Override
	public VehicleEntity add(VehicleEntity bean) throws DuplicateRecordException {
		try {
			Optional<VehicleEntity> getId = dao.findById(bean.getId());
			if (getId.isPresent()) {
				throw new DuplicateRecordException("The Id is already added");
			}

			else {
				return dao.save(bean);
			}

		} catch (DataAccessException e) {
			throw new DuplicateRecordException(e.getMessage());
		} catch (Exception e) {
			throw new DuplicateRecordException(e.getMessage());
		}
//		return dao.save(bean);
	}

	@Override
	public VehicleEntity update(VehicleEntity bean) throws RecordNotFoundException {
		try {
			if (bean.getName().isEmpty()) {

				throw new RecordNotFoundException("Name not found");
			} else {

				return dao.save(bean);
			}

		} catch (DataAccessException e) {
			throw new RecordNotFoundException(e.getMessage());
		} catch (Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		}
//		return dao.save(bean);
	}

	@Override
	public VehicleEntity delete(long id) throws RecordNotFoundException {
		try {
			Optional<VehicleEntity> guard = dao.findById(id);
			if (!guard.isPresent()) {
				throw new RecordNotFoundException("Id Not Found");
			} else {
				return dao.deleteById(id);
			}

		} catch (DataAccessException e) {
			throw new RecordNotFoundException(e.getMessage());
		} catch (Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		}
	}
//		dao.deleteById(id);

	@Override
	public VehicleEntity findByName(String name) throws RecordNotFoundException {
		try {
			Optional<VehicleEntity> vehicle = dao.findByName(name);
			if (!vehicle.isPresent()) {
				throw new RecordNotFoundException("Name not found");
			} else {
				return vehicle.get();
			}

		} catch (DataAccessException e) {
			throw new RecordNotFoundException(e.getMessage());
		} catch (Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		}
//		return dao.findByName(name);
	}

	@Override
	public VehicleEntity findByPk(String id) throws RecordNotFoundException {
		try {
			Optional<VehicleEntity> optional = dao.findByVehicleNo(id);
			if (optional.isPresent()) {
				return optional.get();
			} else {
				throw new RecordNotFoundException("Invalid id");
			}

		} catch (DataAccessException e) {
			throw new RecordNotFoundException(e.getMessage());
		} catch (Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		}
//		return dao.findById(id);
	}

	@Override
	public List<VehicleEntity> search(VehicleEntity bean, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VehicleEntity> search() throws DatabaseException {
		try {

			if (dao.findAll().isEmpty()) {
				throw new DatabaseException("No Records available in Database");
			} else {
				return dao.findAll();
			}

		} catch (DataAccessException e) {
			throw new DatabaseException(e.getMessage());
		} catch (Exception e) {
			throw new DatabaseException(e.getMessage());
		}
	}
//		return dao.findAll();
}
