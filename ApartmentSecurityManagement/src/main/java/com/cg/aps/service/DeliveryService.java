package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import com.cg.aps.entities.DeliveryEntity;

/**
 * @author Vishal Rana
 *
 */
public interface DeliveryService {

	/**
	 * @param bean
	 * @return
	 */
	public DeliveryEntity add(DeliveryEntity bean);

	/**
	 * @param bean
	 * @return
	 */
	public DeliveryEntity update(DeliveryEntity bean);

	/**
	 * @param id
	 */
	public void delete(long id);

	/**
	 * @param name
	 * @return
	 */
	public List<DeliveryEntity> findByOwnerName(String name);

	/**
	 * @param id
	 * @return
	 */
	public Optional<DeliveryEntity> findByPk(long id);

	/**
	 * @param bean
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<DeliveryEntity> search(DeliveryEntity bean, long pageNo, int pageSize);

	/**
	 * @return
	 */
	public List<DeliveryEntity> search();

}
