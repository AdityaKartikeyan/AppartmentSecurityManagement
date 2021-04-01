package com.cg.aps.service;

import java.util.List;


import com.cg.aps.entities.DomesticHelpEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;

public interface DomesticHelpService {
	

	public DomesticHelpEntity add(DomesticHelpEntity bean) throws DuplicateRecordException;
	
	public DomesticHelpEntity update(DomesticHelpEntity bean) throws RecordNotFoundException;
	
	public DomesticHelpEntity delete(long id) throws RecordNotFoundException;
	
	public DomesticHelpEntity findByName(String name) throws RecordNotFoundException;
	
	public DomesticHelpEntity findByPk(String id) throws RecordNotFoundException;
	
	public List<DomesticHelpEntity> search(DomesticHelpEntity bean, long pageNo, int pageSize);
	
	public List<DomesticHelpEntity> search() throws DatabaseException;

	
}
