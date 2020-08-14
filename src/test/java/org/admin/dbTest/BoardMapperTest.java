package org.admin.dbTest;

import javax.sound.midi.MidiDevice.Info;

import org.jin.domain.BoardVO;
import org.jin.domain.Cirteria;
import org.jin.mapper.BoardDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)		// �׽�Ʈ �� �����ϱ� ���� SpringJUnit4ClassRunner ����
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BoardDAO dao;
	
/*	@Test
	public void testCreate() throws Exception{
		BoardVO board = new BoardVO();
		
		board.setTitle("���ο� ������ �ֽ��ϴ�");
		board.setContent("���ο� ���� �ֽ��ϴ�.");
		board.setWriter("user00");
		
		dao.create(board);
	}*/
/*	@Test
	public void TestRead() throws Exception{
		BoardVO vo = new BoardVO();
		
		vo.setBno(1);
		logger.info(""+dao.read(vo));
	}
	@Test
	public void TestUpdate() throws Exception{
		BoardVO vo = new BoardVO();
		
		vo.setTitle("�����ߴ�.");
		vo.setContent("���뵵 �����ߴ�");
		vo.setBno(2);
		
		dao.update(vo);
	}*/
/*	@Test
	public void TestDelete() throws Exception{
		BoardVO vo = new BoardVO();
		
		vo.setBno(1);
		dao.delete(vo);	
	}*/
/*	@Test
	public void TestList() throws Exception{
		
		BoardVO vo = new BoardVO();
		
		dao.lsistAll().forEach(action->logger.info(""+action));
	}*/
	/*@Test
	public void testListPage() throws Exception{
		Cirteria cri = new Cirteria();
		cri.setPageNum(2);
		cri.setAmount(10);
		dao.listPage(cri).forEach(board->logger.info(""+board));;
	}*/
	
	@Test
	public void testSearch() throws Exception{
		
		Cirteria cri = new Cirteria();
		cri.setKeyword("����");
		cri.setType("TC");
		dao.listPage(cri).forEach(board->logger.info(""+board));
		
	}
}
