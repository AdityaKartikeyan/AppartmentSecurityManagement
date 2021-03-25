/**
 * 
 */
package com.cg.aps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.aps.entities.SecurityEntity;
/**
 * @author Administrator
 *
 */
@Repository
public interface SecurityDao extends JpaRepository<SecurityEntity,Integer>{

}
