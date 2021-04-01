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

	//Adding a Visitor
	@Override
	public VisitorEntity add(VisitorEntity bean) throws DuplicateRecordException {
			Optional<VisitorEntity> getId = dao.findByVisitorId(bean.getVisitorId());
			if (getId.isPresent()) {
				throw new DuplicateRecordException("The Id is already added");
			}
			else {
				return dao.save(bean);
			}
	}

	//Updating a Visitor
	@Override
	public VisitorEntity update(VisitorEntity bean) throws RecordNotFoundException {
			if (bean.getName().isEmpty()) {
				throw new RecordNotFoundException("Name not found");
			} else {
				return dao.save(bean);
			}
	}

	//Deleting a Visitor
	@Override
	public VisitorEntity delete(long id) throws RecordNotFoundException {
		Optional<VisitorEntity> visitor =dao.findById(id);
		if (!visitor.isPresent()) {
			throw new RecordNotFoundException("Id Not Found");
		} else {
		     return dao.deleteById(id);
		}
	}

	//Searching a Visitor by Name
	@Override
	public VisitorEntity findByName(String name) throws RecordNotFoundException {
			Optional<VisitorEntity> visitor = dao.findByName(name);
			if (!visitor.isPresent()) {
				throw new RecordNotFoundException("Name not found");
			} else {
				return visitor.get();
			}
	}

	//Searching a Visitor by Visitor ID
	@Override
	public VisitorEntity findByPk(String visitorId) throws RecordNotFoundException {
			Optional<VisitorEntity> optional = dao.findByVisitorId(visitorId);
			if (optional.isPresent()) {
				return optional.get();
			} else {
				throw new RecordNotFoundException("Invalid id");
			}
	}

	//Searching all the Visitors
	@Override
	public List<VisitorEntity> search() throws DatabaseException {
			if (dao.findAll().isEmpty()) {
				throw new DatabaseException("No Records available in Database");
			} else {
				return dao.findAll();
			}
	}
}