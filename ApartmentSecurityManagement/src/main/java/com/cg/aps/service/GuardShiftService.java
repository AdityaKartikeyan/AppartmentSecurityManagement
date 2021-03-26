package com.cg.aps.service;

import com.cg.aps.entities.GuardShiftEntity;

import java.util.List;
import java.util.Optional;

/**
 * @author HP
 *
 */
public interface GuardShiftService 
{
public GuardShiftEntity add(GuardShiftEntity bean);
	
	public GuardShiftEntity update(GuardShiftEntity bean);
	
	public void delete(long id);
	
	public List<GuardShiftEntity> findByName(String name);
	
	public Optional<GuardShiftEntity> findByPk(long id);
	
	public List<GuardShiftEntity> search(GuardShiftEntity bean, long pageNo, int pageSize);
	
	public List<GuardShiftEntity> search();

}
