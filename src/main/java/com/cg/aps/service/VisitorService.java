/**
 * @author AMBARISH DATAR
 *
 */
package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entities.VisitorEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;

public interface VisitorService {
	
	public VisitorEntity add(VisitorEntity bean)throws DuplicateRecordException;
	
	public VisitorEntity update(VisitorEntity bean)throws RecordNotFoundException;
	
	public VisitorEntity delete(long id)throws RecordNotFoundException;
	
	public VisitorEntity findByName(String name)throws RecordNotFoundException;
	
	public VisitorEntity findByPk(String visitorId) throws RecordNotFoundException;
	
	public List<VisitorEntity> search() throws DatabaseException;

}
