package org.jin.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SampleAdvice {
	private static final Logger logger = 
			LoggerFactory.getLogger(SampleAdvice.class);
	
	@Before("execution(* org.jin.service.SampleService*.*(..))")
	public void startLog() {
		logger.info("-----------------------");
		logger.info("-----------------------");
	}
	@Before("execution(* org.jin.service.SampleService*.*(..)) && args(str1,str2)") 
	public void  WithParam(String str1, String str2) {
		logger.info("str 1 : " + str1);
		logger.info("str 2 : " + str2);
	}
}
