package org.jin.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	// 현재 시간과 날짜를 조회하는 SQL 문장 
	@Select("select sysdate()")
	public String getTime();	//추상 메서드
	public String getTime2();	//추상 메서드
}
