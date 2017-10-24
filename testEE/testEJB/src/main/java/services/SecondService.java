package services;

import javax.ejb.Stateless;

@Stateless
public class SecondService {

	public String doBusiness(String input) {
		return this.toString() + " " + input;
	}
}
