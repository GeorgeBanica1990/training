package xml.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import xml.model.Book;
import xml.model.BookStore;

public class XMLService {

	private static final String BOOKSTORE_XML = "./bookstore-jaxb.xml";

	public BookStore createBookstore() {
		List<Book> bookList = new ArrayList<Book>();

		Book book1 = createBook("author1", "isbn1", "name1", "publisher1");
		Book book2 = createBook("author2", "isbn2", "name2", "publisher2");
		Book book3 = createBook("author3", "isbn3", "name3", "publisher3");
		Book book4 = createBook("author4", "isbn4", "name4", "publisher4");

		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		bookList.add(book4);

		BookStore bookstore = new BookStore();
		bookstore.setName("bookstore1");
		bookstore.setLocation("aici");
		bookstore.setBookList(bookList);

		return bookstore;
	}

	public static Book createBook(String author, String isbn, String name, String publisher) {
		Book book1 = new Book();
		book1.setAuthor(author);
		book1.setIsbn(isbn);
		book1.setName(name);
		book1.setPublisher(publisher);
		return book1;
	}

	public void writeWithJAXB(BookStore bookstore) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(BookStore.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(bookstore, new File(BOOKSTORE_XML));

	}

	public BookStore readContentJAXB(String xmlFilePath) throws JAXBException, FileNotFoundException {
		File xmlFile = new File(xmlFilePath);
		System.out.println("read from XML");
		JAXBContext context = JAXBContext.newInstance(BookStore.class);
		Unmarshaller unMarshaller = context.createUnmarshaller();
		BookStore bookstore = (BookStore) unMarshaller.unmarshal(new FileReader(xmlFile));
		
		return bookstore;
	}
}
