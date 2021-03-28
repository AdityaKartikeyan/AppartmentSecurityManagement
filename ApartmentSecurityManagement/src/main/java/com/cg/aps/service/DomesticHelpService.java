package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import com.cg.aps.entities.DomesticHelpEntity;

public interface DomesticHelpService {
	

	public DomesticHelpEntity add(DomesticHelpEntity bean);
	
	public void update(DomesticHelpEntity bean);
	
	public void delete(DomesticHelpEntity bean);
	
	public DomesticHelpEntity findByName(String name);
	
	public DomesticHelpEntity findByPk(long id);
	
	public List<DomesticHelpEntity> search(DomesticHelpEntity bean, long pageNo, int pageSize);
	
	public List<DomesticHelpEntity> search(DomesticHelpEntity bean);

	
}
