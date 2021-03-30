package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cg.aps.entities.GuardSalaryEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.repository.GuardSalaryDao;


/**
 * @author Aravind
 *
 */
@Service("GuardSalaryService")
@Transactional
public class GuardSalaryServiceImpl implements GuardSalaryService {
	
	@Autowired
	GuardSalaryDao dao;

	@Override
	public GuardSalaryEntity add(GuardSalaryEntity bean) throws DuplicateRecordException {
		try {

				
				  Optional<GuardSalaryEntity> getId = dao.findByUserId(bean.getUserId());
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
	public GuardSalaryEntity update(GuardSalaryEntity bean)throws RecordNotFoundException {
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
	public GuardSalaryEntity delete(long id) throws RecordNotFoundException{
		try {
		Optional<GuardSalaryEntity> guard =dao.findById(id);
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

	@Override
	public GuardSalaryEntity findByName(String name) throws RecordNotFoundException{
		try {			
			 Optional<GuardSalaryEntity> guard =dao.findByName(name);
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
	public GuardSalaryEntity findByPk(long id) throws RecordNotFoundException {
		try {			
			Optional<GuardSalaryEntity> optional = dao.findByUserId(id);
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
	public List<GuardSalaryEntity> search() throws DatabaseException {
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



