package com.cg.aps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entities.DomesticHelpEntity;
@Repository

public interface DomesticHelpDao extends JpaRepository<DomesticHelpEntity,Integer> {
	List<DomesticHelpEntity> findByName(String name);

}
