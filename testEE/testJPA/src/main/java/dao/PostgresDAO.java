package dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Person;

@Stateless
public class PostgresDAO {

	private static final String PERSISTENCE_UNIT_NAME = "managedPersistenceUnitPostgre";

	@PersistenceContext(unitName = PERSISTENCE_UNIT_NAME)
	private EntityManager em;

	public void create() {
		Person person = new Person();
		person.setName("gigel " + new Date().getTime());
		em.persist(person);
	}
	
	public void updatePerson(Person person) {
		em.persist(person);
	}
	
	public void createPersonWithName(String name) {
		Person person = new Person();
		person.setName(name);
		em.persist(person);
	}

	public void delete() {
		em.createQuery("delete from Person").executeUpdate();
	}

	public List<Person> list() {
		return em.createQuery("select t from Person t", Person.class).getResultList();
	}

	public Person findById(int i) {
		return em.find(Person.class, 1);
		
	}

}
