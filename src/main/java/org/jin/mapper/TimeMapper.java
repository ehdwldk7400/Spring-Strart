package org.jin.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	// ���� �ð��� ��¥�� ��ȸ�ϴ� SQL ���� 
	@Select("select sysdate()")
	public String getTime();	//�߻� �޼���
	public String getTime2();	//�߻� �޼���
}
