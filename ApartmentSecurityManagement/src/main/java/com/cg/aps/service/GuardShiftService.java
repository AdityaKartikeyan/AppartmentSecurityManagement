package com.cg.aps.service;

import com.cg.aps.entities.GuardShiftEntity;

import java.util.List;

public interface GuardShiftService 
{
public long add(GuardShiftEntity bean);
	
	public void update(GuardShiftEntity bean);
	
	public void delete(GuardShiftEntity bean);
	
	public GuardShiftEntity findByName(String name);
	
	public GuardShiftEntity findByPk(long id);
	
	public List<GuardShiftEntity> search(GuardShiftEntity bean, long pageNo, int pageSize);
	
	public List<GuardShiftEntity> search(GuardShiftEntity bean);

}
