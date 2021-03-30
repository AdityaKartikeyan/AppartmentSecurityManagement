package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cg.aps.entities.FlatEntity;
import com.cg.aps.entities.FlatRentEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.repository.FlatDaoInt;

@Service("FlatService")
@Transactional

public class FlatServiceImpl implements FlatServiceInt {

	
	@Autowired
	FlatDaoInt dao;
	
	@Override
	public FlatEntity add(FlatEntity bean) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		try {

			
			  Optional<FlatEntity> getid = dao.findByFlatNo(bean.getFlatNo());
			  if(getid.isPresent())
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
	public FlatEntity update(FlatEntity bean) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {			
			  if(bean.getOwnerName().isEmpty())
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
	public FlatEntity delete(long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<FlatEntity> guard =dao.findById(id);
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
	public FlatEntity findByName(String name) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			   Optional<FlatEntity> flat =dao.findByOwnerName(name);
			   if(!flat.isPresent())
			   {
				   throw new RecordNotFoundException("Name not found");
			   }
			   else
			   {
				   return flat.get();
			   }
			
			}catch(DataAccessException e) {
				throw new RecordNotFoundException(e.getMessage());
			}catch(Exception e) {
				throw new RecordNotFoundException(e.getMessage());
			}
	}

	@Override
	public FlatEntity findByPk(String id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {			
			Optional<FlatEntity> getid = dao.findByFlatNo(id);
			if(getid.isPresent()) {
				return getid.get();
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
	public List<FlatEntity> search(FlatEntity bean, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlatEntity> search() throws DatabaseException {
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


