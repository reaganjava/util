package com.reagan.util.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAspect {

	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		return pjp;
	}
}
