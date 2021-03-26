package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.aps.entities.DomesticHelpEntity;
import com.cg.aps.repository.DomesticHelpDao;


@Service("DomesticHelpService")
@Transactional
public class DomesticHelpServiceImpl implements DomesticHelpService {
@Autowired
DomesticHelpDao dao;

	@Override
	public DomesticHelpEntity add(DomesticHelpEntity bean) {
		// TODO Auto-generated method stub
		return dao.save(bean);
	}

	@Override
	public DomesticHelpEntity update(DomesticHelpEntity bean) {
		// TODO Auto-generated method stub
		return dao.save(bean);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		dao.deleteById((int) id);
	}

	@Override
	public List<DomesticHelpEntity> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<DomesticHelpEntity> findByPk(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DomesticHelpEntity> search(DomesticHelpEntity bean, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DomesticHelpEntity> search() {
		// TODO Auto-generated method stub
		return null;
	}

}
