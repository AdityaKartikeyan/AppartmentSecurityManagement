package com.cg.aps.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.aps.entities.VehicleEntity;
import com.cg.aps.repository.VehicleDao;

/**
 * @author Anshul Joshi
 *
 */
@Service("VehicleService")
@Transactional
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleDao dao;

	@Override
	public VehicleEntity add(VehicleEntity bean) {
		// TODO Auto-generated method stub
		return dao.save(bean);
	}

	@Override
	public VehicleEntity update(VehicleEntity bean) {
		// TODO Auto-generated method stub
		return dao.save(bean);
	}

	@Override
	public void delete(VehicleEntity bean) {
		// TODO Auto-generated method stub
		dao.delete(bean);
	}

	@Override
	public VehicleEntity findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VehicleEntity findByPk(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VehicleEntity> search(VehicleEntity bean, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VehicleEntity> search(VehicleEntity bean) {
		// TODO Auto-generated method stub
		return null;
	}

}
