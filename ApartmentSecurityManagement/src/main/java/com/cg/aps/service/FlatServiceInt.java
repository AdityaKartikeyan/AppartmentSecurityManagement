package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entities.FlatEntity;



public interface FlatServiceInt {

	public long add(FlatEntity bean);
	
	public void update(FlatEntity bean);
	
	public void delete(FlatEntity bean);
	
	public FlatEntity findByName(String name);
	
	public FlatEntity findByPk(long id);
	
	public List<FlatEntity> search(FlatEntity bean, long pageNo, int pageSize);
	
	public List<FlatEntity> search(FlatEntity bean);
	
	
}
