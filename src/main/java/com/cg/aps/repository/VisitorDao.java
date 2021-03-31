/**
 * @author AMBARISH DATAR
 *
 */
package com.cg.aps.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entities.VisitorEntity;

@Repository
public interface VisitorDao extends JpaRepository <VisitorEntity,Long> {

	//Finding by name
	Optional<VisitorEntity> findByName(String name);

	//Finding by visitorId
	Optional<VisitorEntity> findByVisitorId(String visitorId);
	
	//Deleting by ID 
	VisitorEntity deleteById(long id);
	
}
