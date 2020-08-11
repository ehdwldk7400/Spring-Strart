package org.jin.mapper;

import java.util.List;

import org.jin.domain.BoardVO;

public interface BoardDAO {
	
	//�۾���
	public void create(BoardVO vo) throws Exception; 
	
	// ���� Ŭ�� �� �Ѱ��� ���� select
	public BoardVO read(BoardVO vo) throws Exception;
	
	//�ۼ���
	public void update(BoardVO vo) throws Exception;
	
	//�ۻ���
	public void delete(BoardVO vo) throws Exception;
	
	// �Խñ� ����Ʈ
	public List<BoardVO> lsistAll() throws Exception;
}
