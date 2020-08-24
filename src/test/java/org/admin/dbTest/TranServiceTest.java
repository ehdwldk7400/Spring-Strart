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

@RunWith(SpringJUnit4ClassRunner.class)		// �׽�Ʈ �� �����ϱ� ���� SpringJUnit4ClassRunner ����
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TranServiceTest {
	private static final Logger logger = 
			LoggerFactory.getLogger(SampleAdvice.class);
	@Autowired
	private TranService service;
	
	@Test
	public void testTran() {
		String str="�ȳ��ϼ���. �׸���ǻ�;�ī���̿� ���� ���� ȯ���մϴ�. �� ������ �������� �缺�Ʒð������Դϴ�.";
		
		service.addData(str);
	}
}
