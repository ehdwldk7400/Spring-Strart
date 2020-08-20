package org.jin.service;

import java.util.List;

import org.jin.domain.Cirteria;
import org.jin.domain.ReplyPageVO;
import org.jin.domain.ReplyVO;
import org.jin.mapper.ReplyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplySerivce{
	@Autowired
	private ReplyDAO dao;
	
	public ReplyPageVO list (int bno, Cirteria cri) throws Exception{
		return new ReplyPageVO(dao.list(bno, cri), dao.getCountBtBno(bno));
	}

	@Override
	public void create(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.create(vo);
	}

	@Override
	public void update(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public void delete(int rno) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(rno);
	}


}
