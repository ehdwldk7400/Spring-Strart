package org.jin.service;

import java.util.List;

import org.jin.domain.ReplyVO;

public interface ReplySerivce {

	// ��� ����Ʈ
	public List<ReplyVO> list (int bno) throws Exception;
	
	public void create(ReplyVO vo) throws Exception;
	
	public void update(ReplyVO vo) throws Exception;
}
