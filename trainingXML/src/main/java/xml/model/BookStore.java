package xml.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

//bookstore is the root-element of the example
@XmlRootElement(namespace = "xml.model")
public class BookStore {

	//wrapper peste xml representation
	@XmlElementWrapper(name = "bookList")
	@XmlElement(name = "book")
	private List<Book> bookList;

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	private String name;
	private String location;

}
