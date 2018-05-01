package com.training.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAspect {

	public Object aroundABC(ProceedingJoinPoint pjp) throws Throwable {

		System.out.println("start method...");
		Object obj = pjp.proceed();
		System.out.println("end method...");
		return obj;
	}

}
