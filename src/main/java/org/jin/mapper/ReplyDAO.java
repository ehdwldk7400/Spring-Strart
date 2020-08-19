package org.jin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jin.domain.Cirteria;
import org.jin.domain.ReplyVO;

public interface ReplyDAO {
	
	// ��� ����Ʈ ����
//	public List<ReplyVO> list(ReplyVO vo, Cirteria cri) throws Exception;
	public List<ReplyVO> list(@Param("bno") int bno,  @Param("cri") Cirteria cri) throws Exception;
	
	// ��� ����
	public void create(ReplyVO vo) throws Exception;
	
	// ��� ����
	public void update(ReplyVO vo) throws Exception;
	
	// ��� ����
	public void delete(int rno) throws Exception;

}
