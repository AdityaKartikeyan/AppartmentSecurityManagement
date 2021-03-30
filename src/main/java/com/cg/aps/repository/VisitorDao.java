/**
 * @author AMBARISH DATAR
 *
 */
package com.cg.aps.repository;

//import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entities.VisitorEntity;

@Repository
public interface VisitorDao extends JpaRepository <VisitorEntity,Long> {

	Optional<VisitorEntity> findByName(String name);

	Optional<VisitorEntity> findByVisitorId(String visitorId);
	
	VisitorEntity deleteById(long id);
	
}
