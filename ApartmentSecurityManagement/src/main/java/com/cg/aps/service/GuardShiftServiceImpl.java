 package com.cg.aps.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.aps.entities.GuardShiftEntity;
import com.cg.aps.repository.GuardShiftDao;

@Service("GuardShiftService")
@Transactional

public class GuardShiftServiceImpl implements GuardShiftService
{
	@Autowired
	GuardShiftDao dao;

	@Override
	public long add(GuardShiftEntity bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(GuardShiftEntity bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(GuardShiftEntity bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GuardShiftEntity findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GuardShiftEntity findByPk(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GuardShiftEntity> search(GuardShiftEntity bean, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GuardShiftEntity> search(GuardShiftEntity bean) {
		// TODO Auto-generated method stub
		return null;
	}

}
