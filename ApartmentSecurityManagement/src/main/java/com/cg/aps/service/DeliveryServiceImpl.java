/**
 * 
 */
package com.cg.aps.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cg.aps.entities.DeliveryEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.repository.DeliveryDao;

/**
 * @author Vishal Rana
 *
 */
@Service("DeliveryService")
@Transactional
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	DeliveryDao dao;

	@Override
	public DeliveryEntity add(DeliveryEntity bean) throws DuplicateRecordException {
		try {
			Optional<DeliveryEntity> getDeliveryId = dao.findByDeliveryId(bean.getDeliveryId());
			if (getDeliveryId.isPresent()) {
				throw new DuplicateRecordException("The DeliveryId is already added");
			} else {
				return dao.save(bean);
			}

		} catch (DataAccessException e) {
			throw new DuplicateRecordException(e.getMessage());
		} catch (Exception e) {
			throw new DuplicateRecordException(e.getMessage());
		}
	}

	@Override
	public DeliveryEntity update(DeliveryEntity bean) throws RecordNotFoundException {
		try {
			if (bean.getOwnerName().isEmpty()) {
				throw new RecordNotFoundException("Name not found");
			} else {
				return dao.save(bean);
			}

		} catch (DataAccessException e) {
			throw new RecordNotFoundException(e.getMessage());
		} catch (Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		}
	}

	@Override
	public DeliveryEntity delete(long deliveryId) throws RecordNotFoundException {
		try {
			Optional<DeliveryEntity> guard = dao.findByDeliveryId(deliveryId);
			if (!guard.isPresent()) {
				throw new RecordNotFoundException("Id Not Found");
			} else {
				return dao.deleteByDeliveryId(deliveryId);
			}

		} catch (DataAccessException e) {
			throw new RecordNotFoundException(e.getMessage());
		} catch (Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		}
	}

	@Override
	public List<DeliveryEntity> findByOwnerName(String name) throws RecordNotFoundException {
		try {
			List<DeliveryEntity> delivery = dao.findByOwnerName(name);
			if (delivery.isEmpty()) {
				throw new RecordNotFoundException("Name not found");
			} else {
				return dao.findByOwnerName(name);
			}

		} catch (DataAccessException e) {
			throw new RecordNotFoundException(e.getMessage());
		} catch (Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		}
	}

	@Override
	public DeliveryEntity findByPk(long deliveryId) throws RecordNotFoundException {
		try {
			Optional<DeliveryEntity> optional = dao.findByDeliveryId(deliveryId);
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
	}

	@Override
	public List<DeliveryEntity> search(DeliveryEntity bean, long pageNo, int pageSize) {
		return Collections.emptyList();
	}

	@Override
	public List<DeliveryEntity> search() throws DatabaseException {
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
}
