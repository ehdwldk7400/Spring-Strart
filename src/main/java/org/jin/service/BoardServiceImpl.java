package org.jin.service;

import java.util.List;

import org.jin.domain.BoardAttachVO;
import org.jin.domain.BoardVO;
import org.jin.domain.Cirteria;
import org.jin.mapper.BoardAttachDAO;
import org.jin.mapper.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO dao;
	
	@Autowired
	private BoardAttachDAO attachDao;
	
	@Transactional
	@Override
	public void create(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.create(vo);
		System.out.println("vo.getbno : " + vo.getBno());
		vo.getAttachList().forEach(attach->{
			attach.setBno(vo.getBno());
			attachDao.insert(attach);
		});
	}

	@Transactional
	@Override
	public BoardVO read(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.boardViewcnt(vo);
		return dao.read(vo);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public void delete(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(vo);
	}

	@Override
	public List<BoardVO> listtAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.lsistAll();
	}

	@Override
	public List<BoardVO> listPage(Cirteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listPage(cri);
	}

	@Override
	public int getToralCount(Cirteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.getToralCount(cri);
	}

	@Override
	public List<BoardAttachVO> getAttachList(int bno) throws Exception {
		// TODO Auto-generated method stub
		return attachDao.select(bno);
	}


	
	
}
