/**
 * 
 */
package com.cg.aps.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entities.DeliveryEntity;

/**
 * @author Vishal Rana
 *
 */
@Repository
public interface DeliveryDao extends JpaRepository<DeliveryEntity, Integer> {

	List<DeliveryEntity> findByOwnerName(String name);
	Optional<DeliveryEntity> findByDeliveryId(long deliveryId);
	void deleteByDeliveryId(long id);

}
