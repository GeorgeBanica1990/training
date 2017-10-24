package services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.PostgresDAO;
import model.Person;

@Stateless
public class PostgresService {

	@EJB
	PostgresDAO postgresDAO;

	public void create() {
		postgresDAO.create();
	}

	public void delete() {
		postgresDAO.delete();
	}

	public List<Person> list() {
		return postgresDAO.list();
	}
	

}
