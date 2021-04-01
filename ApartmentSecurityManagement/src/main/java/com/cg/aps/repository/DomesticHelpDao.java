package com.cg.aps.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entities.DomesticHelpEntity;
@Repository

public interface DomesticHelpDao extends JpaRepository<DomesticHelpEntity,Long> {
	
	Optional <DomesticHelpEntity> findByName(String name);
	Optional <DomesticHelpEntity> findByDomesticHelpId(String id);
    DomesticHelpEntity deleteById(long id);
}
