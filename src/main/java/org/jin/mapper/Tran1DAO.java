package org.jin.mapper;

import org.apache.ibatis.annotations.Insert;

public interface Tran1DAO {

		@Insert("insert into tbl_transaction1 values (#{data})")
		public int inserCol1(String data);
}
