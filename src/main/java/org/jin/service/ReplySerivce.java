package org.jin.service;

import java.util.List;

import org.jin.domain.Cirteria;
import org.jin.domain.ReplyVO;

public interface ReplySerivce {

	// ��� ����Ʈ
	public List<ReplyVO> list (int bno,  Cirteria cri) throws Exception;
	
	// ��� �ۼ�
	public void create(ReplyVO vo) throws Exception;
	
	// ��� ����
	public void update(ReplyVO vo) throws Exception;
	
	// ��� ����
	public void delete(int rno) throws Exception;
}
