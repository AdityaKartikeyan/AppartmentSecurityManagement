/**
 * 
 */
package com.cg.aps.service;

import java.util.List;


import com.cg.aps.entities.SecurityEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;

/**
 * @author Aditya
 *
 */
public interface SecurityService {


	public SecurityEntity add(SecurityEntity bean) throws DuplicateRecordException; 
	public SecurityEntity update(SecurityEntity bean) throws RecordNotFoundException;
	public SecurityEntity delete(long id) throws RecordNotFoundException;
	public SecurityEntity findByPk(String id) throws RecordNotFoundException;  
	public List<SecurityEntity> search() throws DatabaseException;
	
}
