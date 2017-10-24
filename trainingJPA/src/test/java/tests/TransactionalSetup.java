package tests;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;

public abstract class TransactionalSetup extends Setup {

	protected EntityManager em;
	
	@Before
	public void beforeEachTest() {
		em = factory.createEntityManager();
		em.getTransaction().begin();
	}
	
	@After
	public void afterEachTest() {
		//em.getTransaction().rollback();
		em.getTransaction().commit();
		em.close();
	}

}