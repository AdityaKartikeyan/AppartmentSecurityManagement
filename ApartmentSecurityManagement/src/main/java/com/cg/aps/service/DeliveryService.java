package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.aps.entities.DeliveryEntity;

public interface DeliveryService {

	public DeliveryEntity add(DeliveryEntity bean);

	public DeliveryEntity update(DeliveryEntity bean);

	public void delete(DeliveryEntity bean);

	public List<DeliveryEntity> findByOwnerName(String name);

	public Optional<DeliveryEntity> findByPk(long deliveryid);

	public List<DeliveryEntity> search(DeliveryEntity bean, long pageNo, int pageSize);

	public List<DeliveryEntity> search();

}
