 package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cg.aps.entities.GuardShiftEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.repository.GuardShiftDao;

/**
 * @author HP
 *
 */
@Service("GuardShiftService")
@Transactional

public class GuardShiftServiceImpl implements GuardShiftService
{
	@Autowired
	GuardShiftDao dao;

	@Override
	public GuardShiftEntity add(GuardShiftEntity bean) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		try {

			
			  Optional<GuardShiftEntity> getId = dao.findById(bean.getUserId());
			  if(getId.isPresent())
			  {
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
	}

	@Override
	public GuardShiftEntity update(GuardShiftEntity bean) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {			
			  if(bean.getName().isEmpty())
		        {
		           
		            throw new RecordNotFoundException("Name not found");
		        }
			  else {
				  
				  return dao.save(bean);
			  }
			
		}catch(DataAccessException e) {
			throw new RecordNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		}
	}

	@Override
	public GuardShiftEntity delete(long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try { Optional<GuardShiftEntity> guard =dao.findById(id);
		if (!guard.isPresent()) {
			throw new RecordNotFoundException("Id Not Found");
		} else {
		     return dao.deleteById(id);
		}

	} catch (DataAccessException e) {
		throw new RecordNotFoundException(e.getMessage());
	} catch (Exception e) {
		throw new RecordNotFoundException(e.getMessage());}
	}

	@Override
	public GuardShiftEntity findByName(String name) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			   Optional<GuardShiftEntity> guard =dao.findByName(name);
			   if(!guard.isPresent())
			   {
				   throw new RecordNotFoundException("Name not found");
			   }
			   else
			   {
				   return guard.get();
			   }
			
			}catch(DataAccessException e) {
				throw new RecordNotFoundException(e.getMessage());
			}catch(Exception e) {
				throw new RecordNotFoundException(e.getMessage());
			}
	}

	@Override
	public GuardShiftEntity findByPk(long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {			
			Optional<GuardShiftEntity> optional = dao.findByUserId(id);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new RecordNotFoundException("Invalid id");
			}
		
		}catch(DataAccessException e) {
			throw new RecordNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		}
	
	
	}

	@Override
	public List<GuardShiftEntity> search(GuardShiftEntity bean, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GuardShiftEntity> search() throws DatabaseException {
		// TODO Auto-generated method stub
try {			
			
			if(dao.findAll().isEmpty())
			{
				throw new DatabaseException("No Records available in Database");
			}
			else {
				return dao.findAll();
			}
		
		}catch(DataAccessException e) {
			throw new DatabaseException(e.getMessage());
		}catch(Exception e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	}


