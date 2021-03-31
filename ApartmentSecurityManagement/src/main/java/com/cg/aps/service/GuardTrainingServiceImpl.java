package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cg.aps.entities.GuardTrainingEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.repository.GuardTrainingDao;
/**
 * @author Aditya
 *
 */
@Service("GuardTrainingService")
@Transactional
public class GuardTrainingServiceImpl implements GuardTrainingService {

	@Autowired
	GuardTrainingDao dao;
	@Override
	public GuardTrainingEntity add(GuardTrainingEntity bean) throws DuplicateRecordException {

		try {

			Optional<GuardTrainingEntity> getId = dao.findByUserId(bean.getUserId());
			if (getId.isPresent()) {
				throw new DuplicateRecordException("The Id is already added");
			}

			else {
				return dao.save(bean);
			}

		}  catch (Exception e) {
			throw new DuplicateRecordException(e.getMessage());
		}
		
	}

	@Override
	public GuardTrainingEntity update(GuardTrainingEntity bean) throws RecordNotFoundException {

		try {
			if (bean.getName().isEmpty()) {

				throw new RecordNotFoundException("Name not found");
			} else {

				return dao.save(bean);
			}

		} catch (Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		}

	}

	@Override
	public GuardTrainingEntity delete(long id) throws RecordNotFoundException {

		try {

			Optional<GuardTrainingEntity> guard = dao.findById(id);
			if (!guard.isPresent()) {
				throw new RecordNotFoundException("Id Not Found");
			} else {
				return dao.deleteById(id);
			}

		}  catch (Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		}

	}

	@Override
	public GuardTrainingEntity findByName(String name) throws RecordNotFoundException {

		try {
			Optional<GuardTrainingEntity> guard = dao.findByName(name);
			if (!guard.isPresent()) {
				throw new RecordNotFoundException("Name not found");
			} else {
				return guard.get();
			}

		} catch (Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		} 
	}

	@Override
	public GuardTrainingEntity findByPk(long id) throws RecordNotFoundException {

		try {
			Optional<GuardTrainingEntity> optional = dao.findByUserId(id);
			if (optional.isPresent()) {
				return optional.get();
			} else {
				throw new RecordNotFoundException("Invalid id");
			}

		} catch (Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		}
	}

	
	@Override
	public List<GuardTrainingEntity> search() throws DatabaseException {

		try {

			if (dao.findAll().isEmpty()) {
				throw new DatabaseException("No Records available in Database");
			} else {
				return dao.findAll();
			}

		} catch (Exception e) {
			throw new DatabaseException(e.getMessage());
		}
	}

}
