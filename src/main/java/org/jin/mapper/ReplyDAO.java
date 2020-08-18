package org.jin.mapper;

import java.util.List;

import org.jin.domain.Cirteria;
import org.jin.domain.ReplyVO;

public interface ReplyDAO {
	
	// ´ñ±Û ¸®½ºÆ® º¸±â
//	public List<ReplyVO> list(ReplyVO vo, Cirteria cri) throws Exception;
	public List<ReplyVO> list(int bno) throws Exception;
	
	// ´ñ±Û ¾²±â
	public void create(ReplyVO vo) throws Exception;
	
	// ´ñ±Û ¼öÁ¤
	public void update(ReplyVO vo) throws Exception;
	
	// ´ñ±Û »èÁ¦
	public void delete(ReplyVO vo) throws Exception;

}
