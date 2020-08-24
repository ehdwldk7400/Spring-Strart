package org.jin.Service;

import org.jin.aop.SampleAdvice;
import org.jin.service.SampleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)		// 테스트 런 실행하기 위해 SpringJUnit4ClassRunner 선언
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class SampleServceTests {
	private static final Logger logger = 
			LoggerFactory.getLogger(SampleAdvice.class);
	
	@Autowired
	private SampleService service;
	
	@Test
	public void testService() throws Exception{
		logger.info(""+service.doAdd("123", "456"));
	}
}
