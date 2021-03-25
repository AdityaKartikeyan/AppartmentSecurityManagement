package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import com.cg.aps.entities.GuardSalaryEntity;



/**
 * @author Aravind
 *
 */
public interface GuardSalaryService {
	

	public GuardSalaryEntity add(GuardSalaryEntity bean);

	public GuardSalaryEntity update(GuardSalaryEntity bean);

	public void delete(GuardSalaryEntity bean);

	public List<GuardSalaryEntity> findByName(String name);

	public Optional<GuardSalaryEntity> findByPk(long id);

	public List<GuardSalaryEntity> search(GuardSalaryEntity bean, long pageNo, int pageSize);

	public List<GuardSalaryEntity> search(GuardSalaryEntity bean);

}
