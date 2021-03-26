/**
 * @author AMBARISH DATAR
 *
 */
package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import com.cg.aps.entities.VisitorEntity;

public interface VisitorService {
	
	public VisitorEntity add(VisitorEntity bean);
	
	public VisitorEntity update(VisitorEntity bean);
	
	public void delete(VisitorEntity bean);
	
	public List<VisitorEntity> findByName(String name);
	
	public Optional<VisitorEntity> findByPk(int id);
	
	public List<VisitorEntity> search(VisitorEntity bean, long pageNo, int pageSize);
	
	public List<VisitorEntity> search();
	
}
