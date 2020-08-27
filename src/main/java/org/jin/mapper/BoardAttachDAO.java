package org.jin.mapper;

import java.util.List;

import org.jin.domain.BoardAttachVO;

public interface BoardAttachDAO {
	public void insert(BoardAttachVO vo);
	public void delete(String uudi);
	public List<BoardAttachVO> select(int bno);
}
