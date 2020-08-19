package org.jin.service;

import java.util.List;

import org.jin.domain.Cirteria;
import org.jin.domain.ReplyVO;

public interface ReplySerivce {

	// ´ñ±Û ¸®½ºÆ®
	public List<ReplyVO> list (int bno,  Cirteria cri) throws Exception;
	
	// ´ñ±Û ÀÛ¼º
	public void create(ReplyVO vo) throws Exception;
	
	// ´ñ±Û ¼öÁ¤
	public void update(ReplyVO vo) throws Exception;
	
	// ´ñ±Û »èÁ¦
	public void delete(int rno) throws Exception;
}
