package org.jin.mapper;

import java.util.List;

import org.jin.domain.BoardVO;

public interface BoardDAO {
	
	//글쓰기
	public void create(BoardVO vo) throws Exception; 
	
	// 제목 클릭 후 한건의 대한 select
	public BoardVO read(BoardVO vo) throws Exception;
	
	//글수정
	public void update(BoardVO vo) throws Exception;
	
	//글삭제
	public void delete(BoardVO vo) throws Exception;
	
	// 게시글 리스트
	public List<BoardVO> lsistAll() throws Exception;
}
