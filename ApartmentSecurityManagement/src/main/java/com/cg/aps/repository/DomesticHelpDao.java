package com.cg.aps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entities.DomesticHelpEntity;
@Repository

public interface DomesticHelpDao extends JpaRepository<DomesticHelpEntity,Integer> {
	

}
