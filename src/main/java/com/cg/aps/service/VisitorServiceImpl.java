/**
 * @author AMBARISH DATAR
 *
 */
package com.cg.aps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.aps.entities.VisitorEntity;
import com.cg.aps.repository.VisitorDao;

import java.util.List;
import java.util.Optional;

@Service("VisitorService")
@Transactional
public class VisitorServiceImpl implements VisitorService {

	@Autowired
	VisitorDao dao;
	
	@Override
	public VisitorEntity add(VisitorEntity bean) {
		// TODO Auto-generated method stub
		return dao.save(bean);
	}

	@Override
	public VisitorEntity update(VisitorEntity bean) {
		// TODO Auto-generated method stub
		return dao.save(bean);
	}

	@Override
	public void delete(VisitorEntity bean) {
		// TODO Auto-generated method stub
		dao.delete(bean);
	}

	@Override
	public List<VisitorEntity> findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}

	@Override
	public Optional<VisitorEntity> findByPk(long id) {
		// TODO Auto-generated method stub
		return dao.findById((int) id);
	}

	@Override
	public List<VisitorEntity> search(VisitorEntity bean, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VisitorEntity> search() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
