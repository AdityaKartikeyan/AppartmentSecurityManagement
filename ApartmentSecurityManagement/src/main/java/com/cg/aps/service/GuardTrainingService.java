package com.cg.aps.service;

import java.util.List;
/**
 * @author Aditya
 *
 */

import com.cg.aps.entities.GuardTrainingEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;

public interface GuardTrainingService {

    public GuardTrainingEntity add(GuardTrainingEntity bean) throws DuplicateRecordException;
	
	public GuardTrainingEntity update(GuardTrainingEntity bean) throws RecordNotFoundException;
	
	public GuardTrainingEntity delete(long id) throws RecordNotFoundException;
	
	public GuardTrainingEntity findByName(String name) throws RecordNotFoundException;
	
	public GuardTrainingEntity findByPk(long id) throws RecordNotFoundException;
	
	public List<GuardTrainingEntity> search() throws DatabaseException;
	
	
}
