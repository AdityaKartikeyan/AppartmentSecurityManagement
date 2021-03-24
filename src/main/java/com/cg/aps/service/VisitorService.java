package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entities.VisitorEntity;

public interface VisitorService {
	
	public long add(VisitorEntity bean);
	
	public void update(VisitorEntity bean);
	
	public void delete(VisitorEntity bean);
	
	public VisitorEntity findByName(String name);
	
	public VisitorEntity findByPk(long id);
	
	public List<VisitorEntity> search(VisitorEntity bean, long pageNo, int pageSize);
	
	public List<VisitorEntity> search(VisitorEntity bean);
	
}
