package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cg.aps.entities.FlatRentEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.repository.FlatRentDaoInt;



@Service("FlatRentService")
@Transactional
public class FlatRentServiceImpl implements FlatRentServiceInt{
	
	@Autowired
	FlatRentDaoInt dao;

	@Override
	public FlatRentEntity add(FlatRentEntity bean) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		

			
			  Optional<FlatRentEntity> getid = dao.findByFlatNo(bean.getFlatNo());
			  if(getid.isPresent())
			  {
				  throw new DuplicateRecordException("The Id is already added");
			  }
			  
			else {
				return dao.save(bean);
			}

	}

	@Override
	public FlatRentEntity update(FlatRentEntity bean) throws RecordNotFoundException {
		// TODO Auto-generated method stub
				
			  if(bean.getOwnerName().isEmpty())
		        {
		           
		            throw new RecordNotFoundException("Name not found");
		        }
			  else {
				  
				  return dao.save(bean);
			  }
			
		
	}

	@Override
	public FlatRentEntity delete(long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<FlatRentEntity> guard =dao.findById(id);
		if (!guard.isPresent()) {
			throw new RecordNotFoundException("Id Not Found");
		} else {
		     return dao.deleteById(id);
		}


	}

	@Override
	public FlatRentEntity findByName(String name) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		
			   Optional<FlatRentEntity> flatRent =dao.findByOwnerName(name);
			   if(!flatRent.isPresent())
			   {
				   throw new RecordNotFoundException("Name not found");
			   }
			   else
			   {
				   return flatRent.get();
			   }
			
		
	}

	@Override
	public FlatRentEntity findByPk(String id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
				
			Optional<FlatRentEntity> getid = dao.findByFlatNo(id);
			if(getid.isPresent()) {
				return getid.get();
			}else {
				throw new RecordNotFoundException("Invalid id");
			}
		
		
	}

	@Override
	public List<FlatRentEntity> search(FlatRentEntity bean, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlatRentEntity> search() throws DatabaseException {
		// TODO Auto-generated method stub
		
			
			if(dao.findAll().isEmpty())
			{
				throw new DatabaseException("No Records available in Database");
			}
			else {
				return dao.findAll();
			}
	}
}
		
		
	


