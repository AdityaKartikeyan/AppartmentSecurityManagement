/**
 * 
 */
package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import com.cg.aps.entities.SecurityEntity;

/**
 * @author Administrator
 *
 */
public interface SecurityService {


	public SecurityEntity add(SecurityEntity bean); 
	public SecurityEntity update(SecurityEntity bean);
	public void delete(int id);
	public Optional<SecurityEntity> findByPk(Integer id); 
	public List<SecurityEntity> search(Integer pageNo, Integer pageSize); 
	public List<SecurityEntity> search();
	
}
