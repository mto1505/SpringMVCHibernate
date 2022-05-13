package com.mycompany.springmvchibernate.AOP;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {
	
/*	@Pointcut("execution(* com.in28minutes.spring.aop.springaop.data.*.*(..))")
	public void dataLayerExecution(){}
	*/
	@Pointcut("execution(* com.mycompany.springmvchibernate.Service.Impl.SanPhamService.*(..))")
	public void businessLayerExecution(){}
	
	/*@Pointcut("dataLayerExecution() && businessLayerExecution()")
	public void allLayerExecution(){}*/
	
	/*@Pointcut("bean(*dao*)")
	public void beanContainingDao(){}
	
	@Pointcut("within(com.in28minutes.spring.aop.springaop.data..*)")
	public void dataLayerExecutionWithWithin(){}
*/
	@Pointcut("@annotation(com.mycompany.springmvchibernate.AOP.TrackTime)")
	public void trackTimeAnnotation(){}

}
