package com.ypy.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogInterceptor {
	
	@Before("execution(public * com.ypy.dao.impl..*.*(..))")
	public void before() {
		System.out.println("method start!");
	}
	
	@AfterReturning("execution(public * com.ypy.dao.impl..*.*(..))")
	public void after() {
		System.out.println("method end!");
	}
}
