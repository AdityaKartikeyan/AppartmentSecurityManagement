/**
 * @author AMBARISH DATAR
 *
 */
package com.cg.aps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entities.VisitorEntity;

@Repository
public interface VisitorDao extends JpaRepository <VisitorEntity,Integer> {

	List<VisitorEntity> findByName(String name);
}
