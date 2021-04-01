package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cg.aps.entities.DomesticHelpEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.repository.DomesticHelpDao;

@Service("DomesticHelpService")
@Transactional
public class DomesticHelpServiceImpl implements DomesticHelpService{
	@Autowired
	DomesticHelpDao dao;
	@Override
	public DomesticHelpEntity add(DomesticHelpEntity bean) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		

			
			  Optional<DomesticHelpEntity> getId = dao.findByDomesticHelpId(bean.getDomestichelpId());
			  if(getId.isPresent())
			  {
				  throw new DuplicateRecordException("The Id is already added");
			  }
			  
			else {
				return dao.save(bean);
			}                                                            //add domestic help
	}
	

	@Override
	public DomesticHelpEntity update(DomesticHelpEntity bean) throws RecordNotFoundException {
		// TODO Auto-generated method stub
				
			  if(bean.getName().isEmpty())
		        {
		           
		            throw new RecordNotFoundException("Name not found");
		        }
			  else {
				  
				  return dao.save(bean);                                 //update domestic help
			  }
		
	
	}

	@Override
	public DomesticHelpEntity delete(long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		
			Optional<DomesticHelpEntity> guard = dao.findById(id);
			if (!guard.isPresent()) {
				throw new RecordNotFoundException("Id Not Found");
			} else {
				return dao.deleteById(id);                                // delete domestic help
			}

		
	}

	@Override
	public DomesticHelpEntity findByName(String name) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		
			  Optional <DomesticHelpEntity> domestichelp =dao.findByName(name);
			   if(!domestichelp.isPresent())
			   {
				   throw new RecordNotFoundException("Name not found");
			   }
			   else
			   {
				   return domestichelp.get();                                 // find by name
			   }
			
			
	}

	@Override
	public  DomesticHelpEntity findByPk(String id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
					
			Optional<DomesticHelpEntity> optional = dao.findByDomesticHelpId(id);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new RecordNotFoundException("Invalid id");                  // find by pk
			}
		
		
	}

	@Override
	public List<DomesticHelpEntity> search(DomesticHelpEntity bean, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DomesticHelpEntity> search() throws DatabaseException {
		// TODO Auto-generated method stub
		

			if (dao.findAll().isEmpty()) {
				throw new DatabaseException("No Records available in Database");
			} else {
				return dao.findAll();                                   //search
			}

	
	}
}


	


