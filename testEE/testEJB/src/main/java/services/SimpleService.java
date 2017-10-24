package services;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class SimpleService {

	@EJB
	SecondService secondService;

	public String doBusiness(String input) {
		return this.toString() + " " + secondService.doBusiness(input);
	}
}
