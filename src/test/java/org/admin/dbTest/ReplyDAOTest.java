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

@RunWith(SpringJUnit4ClassRunner.class)		// 테스트 런 실행하기 위해 SpringJUnit4ClassRunner 선언
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
		
		// 게시글 번호
		vo.setBno(2);
		// 댓글 내용
		vo.setReplytext("댓글입니다.3");
		// 댓글 작성자
		vo.setReplyer("관리자");
		
		dao.create(vo);
	}
	
	@Test
	public void testUpdate() throws Exception{
		ReplyVO vo = new ReplyVO();
		
		vo.setRno(2);
		vo.setReplytext("또 수정함");
		
		dao.update(vo);
	}
	@Test
	public void tsetDelete() throws Exception{
		ReplyVO vo = new ReplyVO();
		
		vo.setRno(3);
		dao.delete(vo);
	}
	
}
