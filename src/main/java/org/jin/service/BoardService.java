package org.jin.service;

import java.util.List;

import org.jin.domain.BoardVO;
import org.jin.domain.Cirteria;

public interface BoardService {
	//�۾���
	public void create(BoardVO vo) throws Exception; 
	
	// ���� Ŭ�� �� �Ѱ��� ���� select
	public BoardVO read(BoardVO vo) throws Exception;
	
	//�ۼ���
	public void update(BoardVO vo) throws Exception;
	
	//�ۻ���
	public void delete(BoardVO vo) throws Exception;
	
	// �Խñ� ����Ʈ
	public List<BoardVO> listtAll() throws Exception;
	
	public List<BoardVO> listPage(Cirteria cri) throws Exception;

}
