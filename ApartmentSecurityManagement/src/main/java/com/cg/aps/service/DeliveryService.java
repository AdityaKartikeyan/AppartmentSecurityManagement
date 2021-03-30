package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entities.DeliveryEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;

/**
 * @author Vishal Rana
 *
 */
public interface DeliveryService {

	/**
	 * @param bean
	 * @return
	 * @throws DuplicateRecordException
	 */
	public DeliveryEntity add(DeliveryEntity bean) throws DuplicateRecordException;

	/**
	 * @param bean
	 * @return
	 * @throws RecordNotFoundException
	 */
	public DeliveryEntity update(DeliveryEntity bean) throws RecordNotFoundException;

	/**
	 * @param id
	 * @return
	 * @throws RecordNotFoundException
	 */
	public DeliveryEntity delete(long id) throws RecordNotFoundException;

	/**
	 * @param name
	 * @return
	 * @throws RecordNotFoundException
	 */
	public List<DeliveryEntity> findByOwnerName(String name) throws RecordNotFoundException;

	/**
	 * @param id
	 * @return
	 * @throws RecordNotFoundException
	 */
	public DeliveryEntity findByPk(long id) throws RecordNotFoundException;

	/**
	 * @param bean
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<DeliveryEntity> search(DeliveryEntity bean, long pageNo, int pageSize);

	/**
	 * @return
	 * @throws DatabaseException
	 */
	public List<DeliveryEntity> search() throws DatabaseException;

}
