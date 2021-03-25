/**
 * 
 */
package com.cg.aps.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.aps.entities.SecurityEntity;
import com.cg.aps.repository.SecurityDao;

/**
 * @author Administrator
 *
 */
@Service("SecurityService")
@Transactional
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	SecurityDao dao;
	@Override
	public SecurityEntity add(SecurityEntity bean) {
		// TODO Auto-generated method stub
		return dao.save(bean);
	}

	@Override
	public SecurityEntity update(SecurityEntity bean) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(SecurityEntity bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SecurityEntity findByPk(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SecurityEntity> search(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SecurityEntity> search() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
