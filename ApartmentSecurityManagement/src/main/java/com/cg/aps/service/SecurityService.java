/**
 * 
 */
package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entities.SecurityEntity;

/**
 * @author Administrator
 *
 */
public interface SecurityService {


	public SecurityEntity add(SecurityEntity bean); 
	public SecurityEntity update(SecurityEntity bean);
	public void delete(SecurityEntity bean);
	public SecurityEntity findByPk(Integer id); 
	public List<SecurityEntity> search(Integer pageNo, Integer pageSize); 
	public List<SecurityEntity> search();
	
}
