package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import com.cg.aps.entities.FlatRentEntity;



public interface FlatRentServiceInt {

	public FlatRentEntity add(FlatRentEntity bean);
	
	public FlatRentEntity update(FlatRentEntity bean);
	
	public void delete(String id);
	
	public List<FlatRentEntity> findByName(String name);
	
	public Optional<FlatRentEntity> findByPk(String id);
	
	public List<FlatRentEntity> search(FlatRentEntity bean, long pageNo, int pageSize);
	
	public List<FlatRentEntity> search();
	
	
}
