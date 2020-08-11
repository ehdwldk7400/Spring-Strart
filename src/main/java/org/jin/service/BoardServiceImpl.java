package org.jin.service;

import java.util.List;

import org.jin.domain.BoardVO;
import org.jin.mapper.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO dao;
	
	@Override
	public void create(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.create(vo);
	}

	@Override
	public BoardVO read(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
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
	public List<BoardVO> lsistAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.lsistAll();
	}
	
}
