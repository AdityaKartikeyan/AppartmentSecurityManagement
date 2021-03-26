package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.aps.entities.FlatEntity;
import com.cg.aps.repository.FlatDaoInt;

@Service("FlatService")
@Transactional

public class FlatServiceImpl implements FlatServiceInt {

	
	@Autowired
	FlatDaoInt dao;
	
	@Override
	public FlatEntity add(FlatEntity bean) {
		// TODO Auto-generated method stub
		return dao.save(bean);
	}

	@Override
	public FlatEntity update(FlatEntity bean) {
		// TODO Auto-generated method stub
		return dao.save(bean);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public List<FlatEntity> findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByOwnerName(name);
	}

	@Override
	public Optional<FlatEntity> findByPk(String id) {
		// TODO Auto-generated method stub
		return dao.findByFlatNo(id);
	}

	@Override
	public List<FlatEntity> search(FlatEntity bean, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlatEntity> search() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	

}
