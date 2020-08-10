package org.admin.dbTest;


import org.jin.mapper.TimeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)		// �׽�Ʈ �� �����ϱ� ���� SpringJUnit4ClassRunner ����
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")	// MYSQL���� ������ �Ǿ��ִ°��� ����
public class TimeMapperTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
		logger.info(timeMapper.getClass().getName());
		logger.info(timeMapper.getTime());
	}
	@Test
	public void testGetTime2() {
		logger.info(timeMapper.getClass().getName());
		logger.info(timeMapper.getTime2());
	}
}
