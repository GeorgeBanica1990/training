package models;

import java.lang.reflect.Proxy;

import interfaces.ResourceInterface;

public class ProxyExample {

	public static String createProxy() {
		Resource testClass = new Resource();
		ReflectionExample reflClass = new ReflectionExample(testClass);
		ResourceInterface prxyIntrf = (ResourceInterface) Proxy.newProxyInstance(
				ResourceInterface.class.getClassLoader(), new Class[] { ResourceInterface.class }, reflClass);
		return prxyIntrf.showResource(1, "test");
	}

}
