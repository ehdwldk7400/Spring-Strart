package org.jin.mapper;

import java.util.List;

import org.jin.domain.BoardVO;
import org.jin.domain.Cirteria;

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
	
	// �Խñ� 10�� �� ����Ʈ
	public List<BoardVO> listPage(Cirteria cri) throws Exception;
	
	public int getToralCount(Cirteria cri) throws Exception;
	
	public void boardViewcnt(BoardVO vo) throws Exception;
}
