package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import com.cg.aps.entities.FlatEntity;



public interface FlatServiceInt {

	public FlatEntity add(FlatEntity bean);
	
	public FlatEntity update(FlatEntity bean);
	
	public void delete(String id);
	
	public List<FlatEntity> findByName(String name);
	
	public Optional<FlatEntity> findByPk(String id);
	
	public List<FlatEntity> search(FlatEntity bean, long pageNo, int pageSize);
	
	public List<FlatEntity> search();
	
	
}
