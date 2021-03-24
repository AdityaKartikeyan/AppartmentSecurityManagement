package com.cg.aps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.aps.entities.VisitorEntity;
import com.cg.aps.repository.VisitorDao;

import java.util.List;

@Service("VisitorService")
@Transactional
public class VisitorServiceImpl implements VisitorService {

	@Autowired
	VisitorDao dao;
	
	@Override
	public long add(VisitorEntity bean) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public void update(VisitorEntity bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(VisitorEntity bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public VisitorEntity findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorEntity findByPk(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VisitorEntity> search(VisitorEntity bean, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VisitorEntity> search(VisitorEntity bean) {
		// TODO Auto-generated method stub
		return null;
	}

}
