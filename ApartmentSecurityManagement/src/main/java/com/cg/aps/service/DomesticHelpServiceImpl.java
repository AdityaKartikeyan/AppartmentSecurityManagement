package com.cg.aps.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.aps.entities.DomesticHelpEntity;
import com.cg.aps.repository.DomesticHelpDao;
import com.cg.aps.service.DomesticHelpService;

@Service("DomesticHelpService")
@Transactional
public class DomesticHelpServiceImpl implements DomesticHelpService{
	@Autowired
	DomesticHelpDao dao;
	@Override
	public DomesticHelpEntity add(DomesticHelpEntity bean) {
		// TODO Auto-generated method stub
	//	return dao.save(bean);
		return null;
	}

	@Override
	public void update(DomesticHelpEntity bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(DomesticHelpEntity bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DomesticHelpEntity findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DomesticHelpEntity findByPk(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DomesticHelpEntity> search(DomesticHelpEntity bean, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DomesticHelpEntity> search(DomesticHelpEntity bean) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
