/**
 * 
 */
package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.cg.aps.entities.DeliveryEntity;
import com.cg.aps.repository.DeliveryDao;

/**
 * @author Vishal Rana
 *
 */
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	DeliveryDao dao;

	@Override
	public long add(DeliveryEntity bean) {
		dao.save(bean);
		return bean.getId();
	}

	@Override
	public void update(DeliveryEntity bean) {
		}

	@Override
	public void delete(DeliveryEntity bean) {
		}

	@Override
	public DeliveryEntity findByName(String name) {
		return null;
	}

	@Override
	public DeliveryEntity findByPk(long id) {
		return null;
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
