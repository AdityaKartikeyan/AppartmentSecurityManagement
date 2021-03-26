package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.aps.entities.GuardTrainingEntity;
import com.cg.aps.repository.GuardTrainingDao;

@Service("GuardTrainingService")
@Transactional
public class GuardTrainingServiceImpl implements GuardTrainingService {

	@Autowired
	GuardTrainingDao dao;
	@Override
	public GuardTrainingEntity add(GuardTrainingEntity bean) {
		// TODO Auto-generated method stub
	
		  return dao.save(bean);
		//  return bean.getUserId();
		
		 
		 
		
	}

	@Override
	public GuardTrainingEntity update(GuardTrainingEntity bean) {
		// TODO Auto-generated method stub
		
		return dao.save(bean);
	}

	@Override
	public void delete(long userId) {
		// TODO Auto-generated method stub
		dao.deleteById(userId);
	}

	@Override
	public List<GuardTrainingEntity> findByName(String name) {
		// TODO Auto-generated method stub
	   return  dao.findByName(name);
	}

	@Override
	public Optional<GuardTrainingEntity> findByPk(long id) {
		// TODO Auto-generated method stub
		
		return dao.findById(id);
	}

	@Override
	public List<GuardTrainingEntity> search(GuardTrainingEntity bean, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List<GuardTrainingEntity> search() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
