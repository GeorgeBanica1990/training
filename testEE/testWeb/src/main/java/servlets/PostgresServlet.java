package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Person;
import services.PostgresService;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/PostgresServlet")
public class PostgresServlet extends HttpServlet{

	@EJB
	PostgresService postgresService;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		switch (operation) {
		case "create":
			postgresService.create();
			break;
		case "list":
			List<Person> list = postgresService.list();
			response.getWriter().print(list);
			break;
		case "delete":
			postgresService.delete();
			break;

		default:
			System.out.println("nu ai ales niciuna");
			break;
		}
		
	}
}
