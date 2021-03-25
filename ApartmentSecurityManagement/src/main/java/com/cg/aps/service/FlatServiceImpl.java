package com.cg.aps.service;

import java.util.List;

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
	public void update(FlatEntity bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(FlatEntity bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FlatEntity findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FlatEntity findByPk(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlatEntity> search(FlatEntity bean, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlatEntity> search(FlatEntity bean) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
