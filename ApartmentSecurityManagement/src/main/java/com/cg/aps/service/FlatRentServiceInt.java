package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import com.cg.aps.entities.FlatRentEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;



public interface FlatRentServiceInt {

	public FlatRentEntity add(FlatRentEntity bean) throws DuplicateRecordException;
	
	public FlatRentEntity update(FlatRentEntity bean) throws RecordNotFoundException;
	
	public FlatRentEntity delete(long id) throws RecordNotFoundException;
	
	public FlatRentEntity findByName(String name) throws RecordNotFoundException;
	
	public FlatRentEntity findByPk(String id) throws RecordNotFoundException;
	
	public List<FlatRentEntity> search(FlatRentEntity bean, long pageNo, int pageSize);
	
	public List<FlatRentEntity> search() throws DatabaseException;
	
	
}
