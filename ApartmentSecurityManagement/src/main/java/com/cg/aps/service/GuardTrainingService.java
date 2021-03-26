package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import com.cg.aps.entities.GuardTrainingEntity;

public interface GuardTrainingService {

    public GuardTrainingEntity add(GuardTrainingEntity bean);
	
	public GuardTrainingEntity update(GuardTrainingEntity bean);
	
	public void delete(long userId);
	
	public List<GuardTrainingEntity> findByName(String name);
	
	public Optional<GuardTrainingEntity> findByPk(long id);
	
	public List<GuardTrainingEntity> search(GuardTrainingEntity bean, long pageNo, int pageSize);
	
	public List<GuardTrainingEntity> search();
	
	
}
