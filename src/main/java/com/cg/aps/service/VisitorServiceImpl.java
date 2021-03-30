/**
 * @author AMBARISH DATAR
 *
 */
package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.aps.entities.VisitorEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.repository.VisitorDao;

@Service("VisitorService")
@Transactional
public class VisitorServiceImpl implements VisitorService {

	@Autowired
	VisitorDao dao;

	@Override
	public VisitorEntity add(VisitorEntity bean) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		try {
			Optional<VisitorEntity> getId = dao.findByVisitorId(bean.getVisitorId());
			if (getId.isPresent()) {
				throw new DuplicateRecordException("The Id is already added");
			}
			else {
				return dao.save(bean);
			}
		} catch (Exception e) {
			throw new DuplicateRecordException(e.getMessage());
		}
	}

	@Override
	public VisitorEntity update(VisitorEntity bean) throws RecordNotFoundException {
		// TODO Auto-generated method stub
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
	public VisitorEntity delete(long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
		Optional<VisitorEntity> visitor =dao.findById(id);
		if (!visitor.isPresent()) {
			throw new RecordNotFoundException("Id Not Found");
		} else {
		     return dao.deleteById(id);
		}

		} catch (Exception e) {
		throw new RecordNotFoundException(e.getMessage());
		}
	}

	@Override
	public VisitorEntity findByName(String name) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<VisitorEntity> visitor = dao.findByName(name);
			if (!visitor.isPresent()) {
				throw new RecordNotFoundException("Name not found");
			} else {
				return visitor.get();
			}
		} catch (Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		}
	}

	@Override
	public VisitorEntity findByPk(String visitorId) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<VisitorEntity> optional = dao.findByVisitorId(visitorId);
			if (optional.isPresent()) {
				return optional.get();
			} else {
				throw new RecordNotFoundException("Invalid id");
			}
		}  catch (Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		}
	}

	@Override
	public List<VisitorEntity> search() throws DatabaseException {
		// TODO Auto-generated method stub
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