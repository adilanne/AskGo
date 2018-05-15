package br.laab.askgo.dao.Imp;

import javax.persistence.EntityManager;

import br.laab.askgo.dao.IAgendaDAO;
import br.laab.askgo.entities.Agenda;

public class AgendaDAO extends DAO<Agenda, Long> implements IAgendaDAO{

	public AgendaDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Agenda> getEntityClass() {
		return Agenda.class;
	}
	
}
