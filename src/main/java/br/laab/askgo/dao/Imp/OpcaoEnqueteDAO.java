package br.laab.askgo.dao.Imp;

import javax.persistence.EntityManager;

import br.laab.askgo.dao.IOpcaoEnqueteDAO;
import br.laab.askgo.entities.OpcaoEnquete;

public class OpcaoEnqueteDAO extends DAO<OpcaoEnquete, Long> implements IOpcaoEnqueteDAO{
	
	public OpcaoEnqueteDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<OpcaoEnquete> getEntityClass() {
		return OpcaoEnquete.class;
	}

}
