package interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class EjbInterceptor {
	@AroundInvoke
	public Object intercept(InvocationContext context) throws Exception {
		System.out.println("EJB!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return context.proceed();
	}
}
