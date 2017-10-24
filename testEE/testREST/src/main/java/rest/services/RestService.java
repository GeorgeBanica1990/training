package rest.services;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import rest.interceptors.MyInterceptor;
import rest.model.json.ResultJSON;
import services.PersonService;

@Path("/result")
@MyInterceptor
public class RestService {

	@EJB
	PersonService personService;

	@Path("get/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ResultJSON getJSON(@PathParam("id") Integer id, @QueryParam("text") String text) {
		ResultJSON result = new ResultJSON();
		result.setId(id);
		result.setText(text);
		return result;
	}

	@Path("users")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String addPersons() {
		personService.createUsers("firstuser", "lastUser");
		return "success!!";
	}
	
	@Path("update")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String updatePerson() {
		personService.updateUser();
		return "success!!";
	}
}
