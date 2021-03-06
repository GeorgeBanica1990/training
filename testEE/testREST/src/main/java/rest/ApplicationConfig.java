package rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import rest.services.RestService;

@ApplicationPath("/rest")
public class ApplicationConfig extends Application{
	
	@Override
	public Set<Class<?>> getClasses() {
		
		Set<Class<?>> classesSet = new HashSet<>();
		classesSet.add(RestService.class);
		return classesSet;
	}

}
