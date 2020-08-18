package org.admin.dbTest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.jin.domain.ReplyVO;
import org.jin.mapper.ReplyDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)		// �׽�Ʈ �� �����ϱ� ���� SpringJUnit4ClassRunner ����
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyDAOTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ReplyDAO dao;
	
//	@Test
//	public void testList() throws Exception{
//		ReplyVO vo = new ReplyVO();
//		
//		vo.setBno(2);
//		
////		List<ReplyVO> replies = dao.list(vo);
//		
//		replies.forEach(reply ->logger.info(""+reply));
//	}
	
	@Test
	public void testCreate() throws Exception{
		ReplyVO vo = new ReplyVO();
		
		// �Խñ� ��ȣ
		vo.setBno(2);
		// ��� ����
		vo.setReplytext("����Դϴ�.3");
		// ��� �ۼ���
		vo.setReplyer("������");
		
		dao.create(vo);
	}
	
	@Test
	public void testUpdate() throws Exception{
		ReplyVO vo = new ReplyVO();
		
		vo.setRno(2);
		vo.setReplytext("�� ������");
		
		dao.update(vo);
	}
	@Test
	public void tsetDelete() throws Exception{
		ReplyVO vo = new ReplyVO();
		
		vo.setRno(3);
		dao.delete(vo);
	}
	
}
