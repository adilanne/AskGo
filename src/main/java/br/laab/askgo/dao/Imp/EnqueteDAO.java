package br.laab.askgo.dao.Imp;

import javax.persistence.EntityManager;

import br.laab.askgo.dao.IEnqueteDAO;
import br.laab.askgo.entities.Enquete;

public class EnqueteDAO extends DAO<Enquete, Long> implements IEnqueteDAO{

	public EnqueteDAO(EntityManager manager) {
		super(manager);
	}

	public EnqueteDAO() {
		super();
	}

	@Override
	public Class<Enquete> getEntityClass() {
		return Enquete.class;
	}
	
}
