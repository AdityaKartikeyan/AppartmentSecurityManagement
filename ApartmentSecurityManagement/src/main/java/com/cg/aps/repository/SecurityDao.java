/**
 * 
 */
package com.cg.aps.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.aps.entities.SecurityEntity;
/**
 * @author Aditya
 *
 */
@Repository
public interface SecurityDao extends JpaRepository<SecurityEntity,Long>{

	Optional<SecurityEntity> findByAlertId(String id);
	SecurityEntity deleteById(long id);
}
