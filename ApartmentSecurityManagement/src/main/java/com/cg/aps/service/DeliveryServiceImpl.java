/**
 * 
 */
package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.aps.entities.DeliveryEntity;
import com.cg.aps.repository.DeliveryDao;

/**
 * @author Vishal Rana
 *
 */
@Service("DeliveryService")
@Transactional
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	DeliveryDao dao;

	@Override
	public DeliveryEntity add(DeliveryEntity bean) {
		return dao.save(bean);
	}

	@Override
	public DeliveryEntity update(DeliveryEntity bean) {
		return dao.save(bean);	
	}

	@Override
	public void delete(DeliveryEntity bean) {
		dao.delete(bean);
	}

	@Override
	public List<DeliveryEntity> findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public Optional<DeliveryEntity> findByPk(long id) {
		return dao.findById(null);
	}

	@Override
	public List<DeliveryEntity> search(DeliveryEntity bean, long pageNo, int pageSize) {
		return null;
	}

	@Override
	public List<DeliveryEntity> search(DeliveryEntity bean) {
		return null;
	}
}
