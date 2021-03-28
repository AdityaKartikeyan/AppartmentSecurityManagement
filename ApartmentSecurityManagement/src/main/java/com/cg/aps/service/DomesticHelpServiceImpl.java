package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.aps.entities.DomesticHelpEntity;
import com.cg.aps.repository.DomesticHelpDao;

@Service("DomesticHelpService")
@Transactional
public class DomesticHelpServiceImpl implements DomesticHelpService{
	@Autowired
	DomesticHelpDao dao;
	@Override
	public DomesticHelpEntity add(DomesticHelpEntity bean) {
		// TODO Auto-generated method stub
		return dao.save(bean);
		//return null;
	}

	@Override
	public DomesticHelpEntity update(DomesticHelpEntity bean) {
		// TODO Auto-generated method stub
		return dao.save(bean);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		dao.deleteByFlatNo(id);
	}

	@Override
	public List<DomesticHelpEntity> findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}

	@Override
	public Optional<DomesticHelpEntity> findByPk(String id) {
		// TODO Auto-generated method stub
		return dao.findByFlatNo(id);
	}

	@Override
	public List<DomesticHelpEntity> search(DomesticHelpEntity bean, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DomesticHelpEntity> search() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}


	

}
