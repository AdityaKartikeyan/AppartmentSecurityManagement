 package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.aps.entities.GuardShiftEntity;
import com.cg.aps.repository.GuardShiftDao;

/**
 * @author HP
 *
 */
@Service("GuardShiftService")
@Transactional

public class GuardShiftServiceImpl implements GuardShiftService
{
	@Autowired
	GuardShiftDao dao;

	@Override
	public GuardShiftEntity add(GuardShiftEntity bean) {
		// TODO Auto-generated method stub
		return dao.save(bean);
	}

	@Override
	public GuardShiftEntity update(GuardShiftEntity bean) {
		// TODO Auto-generated method stub
		return dao.save(bean);
	}

	@Override
	public void delete(GuardShiftEntity bean) {
		// TODO Auto-generated method stub
		dao.delete(bean);
	}

	@Override
	public List<GuardShiftEntity> findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}

	@Override
	public Optional<GuardShiftEntity> findByPk(long id) {
		// TODO Auto-generated method stub
		return dao.findById((int) id);
	}

	@Override
	public List<GuardShiftEntity> search(GuardShiftEntity bean, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GuardShiftEntity> search() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
