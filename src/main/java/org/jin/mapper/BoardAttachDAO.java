package org.jin.mapper;

import java.util.List;

import org.jin.domain.BoardAttachVO;
import org.jin.domain.BoardVO;

public interface BoardAttachDAO {
	public void insert(BoardAttachVO vo);
	public void delete(BoardVO vo);
	public List<BoardAttachVO> select(int bno);
}
