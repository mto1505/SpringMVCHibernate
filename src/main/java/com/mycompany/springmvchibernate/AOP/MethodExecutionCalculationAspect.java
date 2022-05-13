package com.mycompany.springmvchibernate.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/*@Around("com.in28minutes.spring.aop.springaop.aspect.CommonJoinPointConfig.trackTimeAnnotation()")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();

		joinPoint.proceed();

		long timeTaken = System.currentTimeMillis() - startTime;
		logger.info("Time Taken by {} is {}", joinPoint, timeTaken);
	}
	*/
	@Around("com.mycompany.springmvchibernate.AOP.CommonJoinPointConfig.trackTimeAnnotation()")
	public void aroundMethod(ProceedingJoinPoint join) throws Throwable
	{
		//before execuse
		logger.info("before execute method: "+join.toString());
		//Object value=join.proceed();
		
		logger.info("after execute method:{} result {}",join.toString());
		
		
	}
	
}
