/**
 * 
 */
package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.cg.aps.entities.SecurityEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.repository.SecurityDao;

/**
 * @author Aditya
 *
 */
@Service("SecurityService")
@Transactional
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	SecurityDao dao;
	@Override
	public SecurityEntity add(SecurityEntity bean) throws DuplicateRecordException {
		
	
		try {	
			  Optional<SecurityEntity> getId = dao.findByAlertId(bean.getAlertId());
			  if(getId.isPresent())
			  {
				  throw new DuplicateRecordException("The Id is already added");
			  }
			  
			else {
				return dao.save(bean);
			}
		}catch(Exception e) {
			throw new DuplicateRecordException(e.getMessage());
		}
	}

	@Override
	public SecurityEntity update(SecurityEntity bean) throws RecordNotFoundException {
		
		try {			
			  if(bean.getAlertMessage().isEmpty())
		        {
		           
		            throw new RecordNotFoundException("Message not found");
		        }
			  else {
				  
				  return dao.save(bean);
			  }
			
		}catch(Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		}
	}

	@Override
	public SecurityEntity delete(long id) throws RecordNotFoundException {
		
		try {
			
			Optional<SecurityEntity> guard =dao.findById(id);
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
	public SecurityEntity findByPk(String id) throws RecordNotFoundException {
		
		try {			
			Optional<SecurityEntity> optional = dao.findByAlertId(id);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new RecordNotFoundException("Invalid id");
			}
		
		}
			catch(Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		}
	}

	

	@Override
	public List<SecurityEntity> search() throws DatabaseException {
		
		
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
