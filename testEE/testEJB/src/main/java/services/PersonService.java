package services;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import dao.PostgresDAO;
import interceptors.EjbInterceptor;
import model.Person;


@Interceptors(EjbInterceptor.class)
@Stateless
public class PersonService {


	@EJB
	PostgresDAO postgresDao;
	
	@EJB
	PersonService self;

	public void createUsers(String firstUser, String secondUser) {
		postgresDao.createPersonWithName(firstUser);
		self.saveWhatever(secondUser);
		//throw new RuntimeException();
	}
	
	@Transactional(value=TxType.REQUIRES_NEW)
	public void saveWhatever (String user) {
		postgresDao.createPersonWithName(user);
	}
	
	public void updateUser() {
		Person person = postgresDao.findById(1);
		person.setName(person.getName() + person.getName());
	}
}
