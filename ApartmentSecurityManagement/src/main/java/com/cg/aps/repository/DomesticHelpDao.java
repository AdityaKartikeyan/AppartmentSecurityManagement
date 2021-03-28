package com.cg.aps.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entities.DomesticHelpEntity;
@Repository

public interface DomesticHelpDao extends JpaRepository<DomesticHelpEntity,String> {
	
	List<DomesticHelpEntity> findByName(String name);
	Optional<DomesticHelpEntity> findByFlatNo(String id);
	void deleteByFlatNo(String id);
}
