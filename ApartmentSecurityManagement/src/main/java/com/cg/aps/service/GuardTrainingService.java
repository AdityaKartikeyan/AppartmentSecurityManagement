package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entities.GuardTrainingEntity;

public interface GuardTrainingService {

    public GuardTrainingEntity add(GuardTrainingEntity bean);
	
	public void update(GuardTrainingEntity bean);
	
	public void delete(GuardTrainingEntity bean);
	
	public GuardTrainingEntity findByName(String name);
	
	public GuardTrainingEntity findByPk(long id);
	
	public List<GuardTrainingEntity> search(GuardTrainingEntity bean, long pageNo, int pageSize);
	
	public List<GuardTrainingEntity> search(GuardTrainingEntity bean);
	
	
}