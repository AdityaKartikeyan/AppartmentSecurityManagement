package com.cg.aps.service;

import com.cg.aps.entities.GuardShiftEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * @author HP
 *
 */
public interface GuardShiftService 
{
public GuardShiftEntity add(GuardShiftEntity bean) throws DuplicateRecordException;
	
	public GuardShiftEntity update(GuardShiftEntity bean) throws RecordNotFoundException;
	
	public GuardShiftEntity delete(long id) throws RecordNotFoundException;
	
	public GuardShiftEntity findByName(String name) throws RecordNotFoundException;
	
	public GuardShiftEntity findByPk(long id) throws RecordNotFoundException;
	
	public List<GuardShiftEntity> search(GuardShiftEntity bean, long pageNo, int pageSize);
	
	public List<GuardShiftEntity> search() throws DatabaseException;

}
