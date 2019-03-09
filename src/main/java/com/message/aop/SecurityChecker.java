package com.message.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityChecker {
	
	private static final Log logger = LogFactory.getLog(SecurityChecker.class);
	
	@Pointcut("@annotation(SecurityCheck)")
	public void checkoutMethodSecurity() {}
	
	@Around("checkoutMethodSecurity()")
	public Object checkSecurity(ProceedingJoinPoint jointPoint) throws Throwable {
		logger.debug("Checking method security");
		return jointPoint.proceed();
	}
	
}
