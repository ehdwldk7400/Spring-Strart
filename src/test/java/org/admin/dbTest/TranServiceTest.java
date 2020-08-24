package org.admin.dbTest;

import org.jin.aop.SampleAdvice;
import org.jin.service.TranService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)		// 테스트 런 실행하기 위해 SpringJUnit4ClassRunner 선언
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TranServiceTest {
	private static final Logger logger = 
			LoggerFactory.getLogger(SampleAdvice.class);
	@Autowired
	private TranService service;
	
	@Test
	public void testTran() {
		String str="안녕하세여. 그린컴퓨터아카데미에 오신 것을 환영합니다. 이 과정은 빅테이터 양성훈련과정입입니다.";
		
		service.addData(str);
	}
}
