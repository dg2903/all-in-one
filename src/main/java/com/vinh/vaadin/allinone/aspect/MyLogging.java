package com.vinh.vaadin.allinone.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLogging {
	@Before("execution(public String students())")
	public void beforeStudents() {
		System.out.println("=====> students aspect");
	}
	
	@Before("execution(* com.vinh.vaadin.allinone.controllers.*.*(..))")
	public void beforeInits() {
		System.out.println("=====> INIT aspect");
	}
}
