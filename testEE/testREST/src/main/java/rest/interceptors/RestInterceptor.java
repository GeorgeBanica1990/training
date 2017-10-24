package rest.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@MyInterceptor
@Interceptor
public class RestInterceptor {

	@AroundInvoke
	public Object intercept(InvocationContext context) throws Exception {
		System.out.println("am interceptat!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return context.proceed();
	}
}
