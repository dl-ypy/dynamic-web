package com.ypy.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
public class LogInterceptor {
	
	public void before() {
		System.out.println("method start!");
	}
	
	public void after() {
		System.out.println("method end!");
	}
}
