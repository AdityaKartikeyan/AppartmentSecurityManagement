package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entities.GuardSalaryEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;

/**
 * @author Aravind
 *
 */
public interface GuardSalaryService {

	public GuardSalaryEntity add(GuardSalaryEntity bean) throws DuplicateRecordException;

	public GuardSalaryEntity update(GuardSalaryEntity bean) throws RecordNotFoundException;

	public GuardSalaryEntity delete(long id) throws RecordNotFoundException;

	public GuardSalaryEntity findByName(String name) throws RecordNotFoundException;

	public GuardSalaryEntity findByPk(long id) throws RecordNotFoundException;

	public List<GuardSalaryEntity> search() throws DatabaseException;

}
