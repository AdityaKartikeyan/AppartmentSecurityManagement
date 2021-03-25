package com.cg.aps.service;

import java.util.List;

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
	public void update(GuardTrainingEntity bean) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void delete(GuardTrainingEntity bean) {
		// TODO Auto-generated method stub
		dao.delete(bean);
	}

	@Override
	public GuardTrainingEntity findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GuardTrainingEntity findByPk(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GuardTrainingEntity> search(GuardTrainingEntity bean, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GuardTrainingEntity> search(GuardTrainingEntity bean) {
		// TODO Auto-generated method stub
		return null;
	}

}
