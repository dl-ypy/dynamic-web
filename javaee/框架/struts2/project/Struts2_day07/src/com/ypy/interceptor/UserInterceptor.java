package com.ypy.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class UserInterceptor implements  Interceptor{
	private String interName;
	public String getInterName() {
		return interName;
	}

	public void setInterName(String interName) {
		this.interName = interName;
	}

	@Override
	public void destroy() {
		System.out.println(interName+":------destroy--------");
	}

	@Override
	public void init() {
		System.out.println(interName+":-----------init----------");
	}

	@Override
	public String intercept(ActionInvocation ar) throws Exception {
		String str = ar.invoke();
		System.out.println(interName+":---------intercept------------"+str);
		return null;
	}

}
