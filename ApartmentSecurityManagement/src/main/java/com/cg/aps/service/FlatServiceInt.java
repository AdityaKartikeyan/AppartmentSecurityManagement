package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import com.cg.aps.entities.FlatEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;



public interface FlatServiceInt {

	public FlatEntity add(FlatEntity bean) throws DuplicateRecordException;
	
	public FlatEntity update(FlatEntity bean) throws RecordNotFoundException;
	
	public FlatEntity delete(long id) throws RecordNotFoundException;
	
	public FlatEntity findByName(String name) throws RecordNotFoundException;
	
	public FlatEntity findByPk(String id) throws RecordNotFoundException;
	
	public List<FlatEntity> search(FlatEntity bean, long pageNo, int pageSize);
	
	public List<FlatEntity> search() throws DatabaseException;

	
	
	
}
