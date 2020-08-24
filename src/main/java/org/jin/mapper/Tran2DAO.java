package org.jin.mapper;

import org.apache.ibatis.annotations.Insert;

public interface Tran2DAO {
	@Insert("insert into tbl_transaction2 values (#{data})")
	public int inserCol1(String data);
}
