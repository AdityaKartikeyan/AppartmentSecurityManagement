/**
 * 
 */
package com.cg.aps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entities.DeliveryEntity;

/**
 * @author Vishal Rana
 *
 */
@Repository
public interface DeliveryDao extends JpaRepository<DeliveryEntity, Integer >  {
	/*
	 * public long add(DeliveryEntity bean);
	 * 
	 * public void update(DeliveryEntity bean);
	 * 
	 * public void delete(DeliveryEntity bean);
	 * 
	 * public DeliveryEntity findByName(String name);
	 * 
	 * public DeliveryEntity findByPk(long id);
	 * 
	 * public List<DeliveryEntity> search(DeliveryEntity bean, long pageNo, int
	 * pageSize);
	 * 
	 * public List<DeliveryEntity> search(DeliveryEntity bean);
	 */}
