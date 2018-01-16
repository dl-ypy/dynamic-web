package struts2_2300_interceptor_simulatio;

public class SecondInterceptor implements Interceptor {

	@Override
	public void intercept(ActionInvocation invocation) {
		System.out.println(2);
		invocation.invoke();
		System.out.println(-2);
	}

}
