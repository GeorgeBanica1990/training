package test;

import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;

import org.junit.Test;
import org.unitils.reflectionassert.ReflectionAssert;

import xml.model.BookStore;
import xml.service.XMLService;

public class XMLBindTest {

	private static final String BOOKSTORE_XML = "./bookstore-jaxb.xml";
	
	@Test
	public void testXML() throws JAXBException, FileNotFoundException {
		XMLService xmlService =  new XMLService();
		BookStore bookstore = xmlService.createBookstore();
		xmlService.writeWithJAXB(bookstore);
		BookStore bookstoreRetrieved = xmlService.readContentJAXB(BOOKSTORE_XML);
		ReflectionAssert.assertLenientEquals(bookstore, bookstoreRetrieved);
	}

	

}
