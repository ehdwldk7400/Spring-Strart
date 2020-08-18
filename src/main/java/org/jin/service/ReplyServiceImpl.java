package org.jin.service;

import java.util.List;

import org.jin.domain.ReplyVO;
import org.jin.mapper.ReplyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplySerivce{
	@Autowired
	private ReplyDAO dao;
	
	public List<ReplyVO> list (int bno) throws Exception{
		return dao.list(bno);
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


}
