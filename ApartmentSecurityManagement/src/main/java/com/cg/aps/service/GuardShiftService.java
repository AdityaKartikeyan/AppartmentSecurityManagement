package com.cg.aps.service;

import com.cg.aps.entities.GuardShiftEntity;

import java.util.List;

/**
 * @author HP
 *
 */
public interface GuardShiftService 
{
public GuardShiftEntity add(GuardShiftEntity bean);
	
	public GuardShiftEntity update(GuardShiftEntity bean);
	
	public void delete(GuardShiftEntity bean);
	
	public List<GuardShiftEntity> findByName(String name);
	
	public GuardShiftEntity findByPk(long id);
	
	public List<GuardShiftEntity> search(GuardShiftEntity bean, long pageNo, int pageSize);
	
	public List<GuardShiftEntity> search(GuardShiftEntity bean);

}
