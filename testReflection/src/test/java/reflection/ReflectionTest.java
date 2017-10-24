package reflection;

import org.junit.Test;

import junit.framework.Assert;
import models.ProxyExample;
import utils.ReflectionUtils;

@SuppressWarnings("rawtypes") 
public class ReflectionTest {

	@Test
	public void test() throws Exception {
		Assert.assertEquals("test", ProxyExample.createProxy());
		Class testclass = Class.forName("models.Resource");
		ReflectionUtils.printReflectionMethods(testclass);
	}

}
