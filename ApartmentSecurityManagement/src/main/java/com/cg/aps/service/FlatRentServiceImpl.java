package com.cg.aps.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.aps.entities.FlatRentEntity;
import com.cg.aps.repository.FlatRentDaoInt;



@Service("FlatRentService")
@Transactional
public class FlatRentServiceImpl implements FlatRentServiceInt{
	
	@Autowired
	FlatRentDaoInt dao;

	@Override
	public FlatRentEntity add(FlatRentEntity bean) {
		// TODO Auto-generated method stub
		return dao.save(bean);
	}

	@Override
	public FlatRentEntity update(FlatRentEntity bean) {
		// TODO Auto-generated method stub
		return dao.save(bean);
	}

	@Override
	public void delete(FlatRentEntity bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FlatRentEntity findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FlatRentEntity findByPk(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlatRentEntity> search(FlatRentEntity bean, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlatRentEntity> search(FlatRentEntity bean) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
