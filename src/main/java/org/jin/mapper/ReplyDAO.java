package org.jin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jin.domain.Cirteria;
import org.jin.domain.ReplyVO;

public interface ReplyDAO {
	
	// 댓글 리스트 보기
//	public List<ReplyVO> list(ReplyVO vo, Cirteria cri) throws Exception;
	public List<ReplyVO> list(@Param("bno") int bno,  @Param("cri") Cirteria cri) throws Exception;
	
	// 현제 게시물 전체 댓글 수
	public int getCountBtBno(int bno) throws Exception;
	
	// 댓글 쓰기
	public void create(ReplyVO vo) throws Exception;
	
	// 댓글 수정
	public void update(ReplyVO vo) throws Exception;
	
	// 댓글 삭제
	public void delete(int rno) throws Exception;

}
