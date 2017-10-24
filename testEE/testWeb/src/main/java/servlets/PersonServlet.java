package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.PersonService;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/PersonServlet")
public class PersonServlet extends HttpServlet{

	@EJB
	PersonService personService;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		personService.createUsers("firstuser", "lastUser");
	}
}
